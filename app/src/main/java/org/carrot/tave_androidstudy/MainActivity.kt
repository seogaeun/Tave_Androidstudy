package org.carrot.tave_androidstudy


import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

@SuppressWarnings("StaticFieldLeak")
//activity의 lifecycle 만들기
class MainActivity : AppCompatActivity() {

    lateinit var db : TodoDatabase
    var todoList :List<ToDoEntity> = listOf<ToDoEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db= TodoDatabase.getInstance(this)!!

        val button_add = findViewById<Button>(R.id.button_add)
        val edittext_todo=findViewById<EditText>(R.id.edittext_todo)
        button_add.setOnClickListener {
            // 버튼 클릭 이벤트에 대한 동작 추가
            val todo = ToDoEntity(null,edittext_todo.text.toString())
            insertData(todo)
        }


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)





    }


    //insert data
    //get data
    //delete data

    //set recyclerview

    fun insertData(todo : ToDoEntity){
        //MainThread vs WorkerThread(Background Thread)
        val insertTask = object : AsyncTask<Unit, Unit, Unit>() {
            override fun doInBackground(vararg p0: Unit?) {
                db.TodoDAO().insert(todo)
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                getAllMemos()
            }
        }
        insertTask.execute()
    }


    fun getAllMemos(){
        val getTask = (object : AsyncTask<Unit, Unit, Unit>(){
            override fun doInBackground(vararg params: Unit?) {
                todoList=db.TodoDAO().getAll()
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                setRecyclerView(todoList)
            }
        }).execute()
    }

    fun deleteMemo(){

    }

    fun setRecyclerView(todoList: List<ToDoEntity>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(this, todoList)
    }

}