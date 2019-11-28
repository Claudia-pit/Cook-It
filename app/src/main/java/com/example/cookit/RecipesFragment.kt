package com.example.cookit


import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookit.R.layout.fragment_recipes
import com.example.cookit.R.layout.list_dialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_recipes.*
import kotlinx.android.synthetic.main.list_dialog.*
import kotlinx.android.synthetic.main.list_dialog.view.*

/**
 * A simple [Fragment] subclass.
 */
class RecipesFragment : Fragment() {

    private lateinit var recyclerViewRecipes : RecyclerView
    private val recipelist = arrayListOf<String>()
    private lateinit var floatingActionButton: FloatingActionButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(fragment_recipes, container, false)
        floatingActionButton = view.findViewById(R.id.floatingActionButton)

        floatingActionButton.setOnClickListener{


            val rcpDialogView = inflater.inflate(list_dialog, container, false)
            val rcpBuilder = AlertDialog.Builder(this.context)
                .setView(rcpDialogView)

            val rcpAlertDialog = rcpBuilder.show()

            rcpDialogView.sendBtn.setOnClickListener {

                rcpAlertDialog.dismiss()
                val rcpItem = rcpAlertDialog.dialogList.text.toString()
                recipelist.add(rcpItem)

            }

            rcpDialogView.cancelBtn.setOnClickListener {
                rcpAlertDialog.dismiss()
            }
        }


        recyclerViewRecipes = view.findViewById(R.id.recyclerView_recipes)
        recyclerViewRecipes.layoutManager = LinearLayoutManager(this.context)
        recyclerViewRecipes.adapter = RecipesAdapter(recipelist, inflater.context)
        return view


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}
