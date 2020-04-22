package com.zacharee1.systemuituner.prefs.secure.specific

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import com.zacharee1.systemuituner.R
import com.zacharee1.systemuituner.interfaces.ISpecificPreference
import com.zacharee1.systemuituner.prefs.secure.base.BaseSecurePreference
import com.zacharee1.systemuituner.util.SettingsType
import com.zacharee1.systemuituner.util.prefManager
import com.zacharee1.systemuituner.util.verifiers.ShowForTouchWiz
import com.zacharee1.systemuituner.util.writeGlobal

class TouchWizNavigationBarColor(context: Context, attrs: AttributeSet) : BaseSecurePreference(context, attrs), ISpecificPreference {
    override val keys: Array<String>
        get() = arrayOf(key, "navigationbar_current_color")
    override var type = SettingsType.GLOBAL

    init {
        key = "navigationbar_color"
        setTitle(R.string.option_touchwiz_navbar_color)
        setSummary(R.string.option_touchwiz_navbar_color_desc)

        dialogTitle = title
        dialogMessage = summary
        iconColor = context.resources.getColor(R.color.pref_color_5, context.theme)
        setIcon(R.drawable.ic_baseline_color_lens_24)

        visibilityVerifier = ShowForTouchWiz(context)
    }

    override fun onValueChanged(newValue: Any?, key: String) {
        context.prefManager.putString("navigationbar_color", newValue?.toString())
        context.prefManager.putString("navigationbar_current_color", newValue?.toString())
        context.writeGlobal("navigationbar_color", newValue)
        context.writeGlobal("navigationbar_current_color", newValue)
    }
}