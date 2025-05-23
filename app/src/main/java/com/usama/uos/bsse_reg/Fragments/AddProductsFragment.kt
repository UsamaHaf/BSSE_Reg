
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.usama.uos.bsse_reg.Models.ProductsModel
import com.usama.uos.bsse_reg.R


class AddProductsFragment : Fragment() {

   private var databaseReference: DatabaseReference? = null
   lateinit var edtProductName: EditText
   lateinit var edtProductInventory: EditText
   lateinit var edtPurchasePrice: EditText
   lateinit var edtSalePrice: EditText
   lateinit var btnAddStock: Button
   lateinit var model: ProductsModel

   override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      val view = inflater.inflate(R.layout.fragment_add_products, container, false)

      btnAddStock = view.findViewById(R.id.btnAddStock)
      edtProductName = view.findViewById(R.id.edtProductName)
      edtProductInventory = view.findViewById(R.id.edtProductInventory)
      edtPurchasePrice = view.findViewById(R.id.edtPurchasePrice)
      edtSalePrice = view.findViewById(R.id.edtSalePrice)


      return view

   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

      databaseReference = FirebaseDatabase.getInstance().reference.child("Products")
      btnAddStock?.setOnClickListener {
         val mStockItemName = edtProductName?.text.toString().trim()
         val mStockItemInventory = edtProductInventory?.text.toString().trim()
         val mWholeSalePrice = edtPurchasePrice?.text.toString().trim()
         val mRetailPrice = edtSalePrice?.text.toString().trim()

         if (mStockItemName.isEmpty()) {
            Toast.makeText(activity, "Please Enter Item Name", Toast.LENGTH_SHORT).show()

         } else if (mStockItemInventory.isEmpty()) {
            Toast.makeText(activity, "Please Enter Inventory", Toast.LENGTH_SHORT).show()

         } else if (mWholeSalePrice.isEmpty()) {
            Toast.makeText(activity, "Please Enter Purchase Price", Toast.LENGTH_SHORT).show()

         } else if (mRetailPrice.isEmpty()) {
            Toast.makeText(activity, "Please Enter Retail Price", Toast.LENGTH_SHORT).show()

         } else {
            addProductStock(mStockItemName, mStockItemInventory.toInt(), mWholeSalePrice.toDouble(), mRetailPrice.toDouble())
         }
      }


   }

   private fun addProductStock(mStockItemName: String, mStockItemInventory: Int, mWholeSalePrice: Double, mRetailPrice: Double) {

      model = ProductsModel()
      val productDB_ID = databaseReference!!.push().key
      model.productName = mStockItemName
      model.productInventory = mStockItemInventory
      model.productPurchasePrice = mWholeSalePrice
      model.productSalePrice = mRetailPrice

      databaseReference?.child(productDB_ID!!)?.setValue(model)

      Toast.makeText(activity, "Product Added Successfully", Toast.LENGTH_SHORT).show()


   }


}