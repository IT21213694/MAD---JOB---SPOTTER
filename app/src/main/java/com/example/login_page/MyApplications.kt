package com.example.login_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MyApplications : AppCompatActivity() {

    private lateinit var aplRecyclerView: RecyclerView
    private lateinit var tvLoadingData:TextView
    private lateinit var aplList:ArrayList<ApplicationModel>
    private lateinit var dbRef:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_applications)


        aplRecyclerView = findViewById(R.id.rvApl)
        aplRecyclerView.layoutManager=LinearLayoutManager(this)
        aplRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.tvLoadingData)

        aplList= arrayListOf<ApplicationModel>()
        getAplsData()
    }

    private fun getAplsData() {
        aplRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE
        dbRef = FirebaseDatabase.getInstance().getReference("Applications")
        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                aplList.clear()
                if(snapshot.exists()){
                    for(aplSnap in snapshot.children){
                        val aplData = aplSnap.getValue(ApplicationModel::class.java)
                        aplList.add(aplData!!)
                    }
                    val mAdapter = AplAdapter(aplList)
                    aplRecyclerView.adapter = mAdapter
                    mAdapter.setOnItemClickListener(object:AplAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@MyApplications,AplDetailsActivity::class.java)

                            //put other data
                            intent.putExtra("aplId",aplList[position].aplId)
                            intent.putExtra("aplName",aplList[position].aplName)
                            intent.putExtra("aplAddress",aplList[position].aplAddress)
                            intent.putExtra("aplEmail",aplList[position].aplEmail)
                            intent.putExtra("aplPhone",aplList[position].aplPhone)
                            startActivity(intent)
                        }

                    })
                    aplRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}