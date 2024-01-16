package com.example.bth_gk;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Order extends AppCompatActivity {

    private EditText editTextName, editTextPrice, editTextQuantity;
    private Button btnAddProduct, btnViewTotal, btnOut, btnViewAll;
    private TextView textViewProductList;

    // dsach chứa sản phẩm
    private ArrayList<Product> productList = new ArrayList<>();


    //thực hiện công việc  khởi tạo cần thiết khi chạy ưnng dụng
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        editTextName = findViewById(R.id.edit_name);
        editTextPrice = findViewById(R.id.edit_price);
        editTextQuantity = findViewById(R.id.edit_quantity);
        btnAddProduct = findViewById(R.id.btn_add);
        btnViewTotal = findViewById(R.id.btn_total);
        btnOut = findViewById(R.id.btn_out);
        btnViewAll = findViewById(R.id.btn_viewAll);
        textViewProductList = findViewById(R.id.textViewProductList);

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct();

                editTextName.setText("");
                editTextPrice.setText("");
                editTextQuantity.setText("");
            }
        });

        btnViewTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewTotalPrice();
            }
        });

        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProductList();

            }
        });

        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addProduct() {
        String name = editTextName.getText().toString();
        String price = (editTextPrice.getText().toString());
        String quantity = (editTextQuantity.getText().toString());


        if(name.isEmpty()){
            showToast("Vui lòng nhập tên sản phẩm");
        } else if (price.isEmpty()){
            showToast("Vui lòng nhập giá");
        } else if (quantity.isEmpty()) {
            showToast("Vui lòng nhập số lượng");
        }
        else{

            Product product = new Product(name, Double.parseDouble(price), Integer.parseInt(quantity));
            productList.add(product);
            updateProductList();
        }




    }

    private void viewTotalPrice() {
        double total = 0;
        for (Product product : productList) {
            total += product.getTotalPrice();
        }

        textViewProductList.setText("Tổng bill: " + total + " VND");
    }

    private void updateProductList() {
        StringBuilder productText = new StringBuilder(" ==============================================\n");
        for (Product product : productList) {
            productText.append(product.toString()).append("\n");
        }

        textViewProductList.setText(productText.toString());
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}