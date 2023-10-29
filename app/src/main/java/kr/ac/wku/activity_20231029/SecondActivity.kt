package kr.ac.wku.activity_20231029

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kr.ac.wku.activity_20231029.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_second)

        binding.btnReturn.setOnClickListener {

//            현재 화면 종료: 밑에 깔린 이전 화면이 드러남
            finish()

        }
    }
}