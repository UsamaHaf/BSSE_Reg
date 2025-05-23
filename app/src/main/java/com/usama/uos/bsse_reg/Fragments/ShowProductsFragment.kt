import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.usama.uos.bsse_reg.Adapter.ProductAdapter
import com.usama.uos.bsse_reg.Databases.DatabaseClient
import com.usama.uos.bsse_reg.Interface.StoreInterfaces
import com.usama.uos.bsse_reg.Models.CartModel
import com.usama.uos.bsse_reg.Models.ProductsModel
import com.usama.uos.bsse_reg.R

class ShowProductsFragment : Fragment(), StoreInterfaces {

   lateinit var rvProducts: RecyclerView
   lateinit var productArrayList: ArrayList<ProductsModel>
   lateinit var productAdapter: ProductAdapter
   lateinit var firebaseDatabase: FirebaseDatabase
   lateinit var firebaseReference: DatabaseReference

   override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      // Inflate the layout for this fragment
      val view = inflater.inflate(R.layout.fragment_show_products, container, false)

      rvProducts = view.findViewById(R.id.rvProducts)
      getProducts()


      return view

   }

   private fun getProducts() {

      firebaseDatabase = FirebaseDatabase.getInstance()
      firebaseReference = firebaseDatabase.getReference("Products")

      firebaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
         override fun onDataChange(snapshot: DataSnapshot) {
            try {
               productArrayList = ArrayList()
               for (eachUser in snapshot.children) {
                  val productsModel: ProductsModel? = eachUser.getValue(ProductsModel::class.java)
                  productArrayList.add(productsModel!!)

               }
               if (productArrayList.isEmpty() || productArrayList.size == 0) {

                  Toast.makeText(requireActivity(), "No Data Found", Toast.LENGTH_SHORT).show()

               } else {
                  productAdapter =
                      ProductAdapter(productArrayList, requireActivity(), this@ShowProductsFragment)
                  rvProducts.adapter = productAdapter
               }
            } catch (e: Exception) {
               Log.e("Error", e.toString())
            }
         }

         override fun onCancelled(error: DatabaseError) {
            Log.e("ErrorDB", error.message)
         }

      })


   }

   override fun addToCartClickListener(view: View?, stockModel: ProductsModel?, position: Int) {

      try {

         val isExist = DatabaseClient.getInstance(requireActivity()).userDatabase.cartDAO()
            .isAlreadyExist(stockModel?.productID)
         if (isExist) {
            Toast.makeText(requireActivity(), "Exist", Toast.LENGTH_LONG).show()
            return
         }
         val cartModel = CartModel()
         cartModel.productName = stockModel?.productName
         cartModel.productName = stockModel?.productName
         cartModel.productPrice = stockModel?.productSalePrice
         cartModel.productInventory = stockModel?.productInventory
         cartModel.productQuantity = 1.0
         cartModel.productID = stockModel?.productID

         DatabaseClient.getInstance(requireActivity()).userDatabase.cartDAO()?.insert(cartModel)

         stockModel?.isAlreadExity = true
         stockModel?.addedQuantity = cartModel.productQuantity
         productAdapter?.notifyDataSetChanged()
         cartUpdate?.onCartCounterUpdate()

      } catch (e: Exception) {
         Log.e("AddToCartClick", e.toString())
      }
      
      

   }

   override fun onPlusClick(view: View?, stockModel: ProductsModel?, position: Int) {
      TODO("Not yet implemented")
   }

   override fun onDeleteClick(view: View?, stockModel: ProductsModel?, position: Int) {
      TODO("Not yet implemented")
   }


}