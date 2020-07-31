package com.example.android.jetpack_demo.libs.behavior

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.android.jetpack_demo.libs.utils.LogUtils
import com.google.android.material.appbar.AppBarLayout


class DemoBehavior : CoordinatorLayout.Behavior<View> {
    constructor() : super()
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        //这里判断dependency所属的View是哪一个,返回true，onDependentViewChanged才执行,否则不执行
        return dependency is AppBarLayout
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        LogUtils.print(
            tag = DemoBehavior::class.java.simpleName,
            message = "onDependentViewChanged >>> child:${child.toString()}  dependency:${dependency.toString()}"
        )
        /*
         *这里获取dependency的top值,也就是AppBarLayout的top,因为AppBarLayout
         *在是向上滚出界面的,我们的因为是和AppBarLayout相反,所以取绝对值.
         */
        val translationY: Float = Math.abs(dependency.top).toFloat()
        child.translationY = translationY
        return true
    }
}