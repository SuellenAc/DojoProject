package br.com.dojo.project.utils

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import br.com.dojo.project.R
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun AppCompatActivity.addFragment(fragment: Fragment, tag: String){
    val manager = supportFragmentManager
    val transaction = manager.beginTransaction()
    transaction.add(R.id.main_container, fragment, tag)
    transaction.addToBackStack(tag)
    transaction.commit()
}

@Suppress("unused")
fun <T : ViewDataBinding> Fragment.fragmentBinding(
    @LayoutRes layoutResId: Int,
    initializer: (T.() -> Unit)? = null
) = FragmentBindingProperty(layoutResId, initializer)

class FragmentBindingProperty<T : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int,
    private val initializer: (T.() -> Unit)?
) : ReadOnlyProperty<Fragment, T> {

    private var binding: T? = null

    override operator fun getValue(
        thisRef: Fragment,
        property: KProperty<*>
    ): T = binding ?: createBinding(thisRef).apply {
        binding = this
        initializer?.invoke(this)
    }

    private fun createBinding(fragment: Fragment): T =
        DataBindingUtil.inflate(fragment.layoutInflater, layoutResId, null, false)
}
