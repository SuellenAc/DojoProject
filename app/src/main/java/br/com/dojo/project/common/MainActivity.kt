package br.com.dojo.project.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import br.com.dojo.project.R
import br.com.dojo.project.databinding.MainActivityBinding
import br.com.dojo.project.utils.addFragment
import br.com.dojo.project.view.chooseParams.view.ChooseParamsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        super.onCreate(savedInstanceState)

        addFragment(ChooseParamsFragment.newInstance(), ChooseParamsFragment.tag)
    }

}
