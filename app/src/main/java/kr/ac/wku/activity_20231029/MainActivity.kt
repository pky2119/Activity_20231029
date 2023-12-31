package kr.ac.wku.activity_20231029

import android.content.Intent
import android.database.DatabaseUtils
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kr.ac.wku.activity_20231029.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//         버튼이 눌리면 => SecondActivity 화면으로 이동

        binding.btnMoveToSecond.setOnClickListener {

//            화면 이동 시키기 : Intent 클래스 활용
//            1. 어디서 출발해서 어디로 도착할지 정보 명시(티켓)

            val myIntent = Intent( this, SecondActivity::class.java )

//            2. myIntent에 적힌대로 실제 화면 이동
            startActivity(myIntent)
        }

        binding.btnMoveToThird.setOnClickListener {

            val myIntent = Intent(this, ThirdActivity::class.java)

//            화면 이동하기 전에 데이터를 myIntent에 첨부

//            edtMessage에 적힌 값을 변수에 저장 => 이 변수를 첨부

            val inputMessage = binding.edtMessage.text.toString()

            myIntent.putExtra("message", inputMessage)

            val inputNumber = binding.edtNumber.text.toString().toInt()

//            하나의 Intent에 여러개의 변수를 첨부 가능( 이름표만 잘 구별하자 )
            myIntent.putExtra("number", inputNumber)

            startActivity(myIntent)
        }


//        전화 걸기 동작
        binding.btnPhoneCall.setOnClickListener {

//        입력한 전화번호 추출 ( 변수 저장 )
            val inputPhoneNum = binding.edtPhoneNum.text.toString()
            
//            어디에 전화를 걸지 번호정보를 기록하는 Uri
            val myUri = Uri.parse("tel:${inputPhoneNum}")
//            전화 앱에 전화번호를 들고 이동
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)

            startActivity(myIntent)

        }
    }
}