function loadData() {
  let tableData=``;
  $.ajax({
    type: "get",
    url: "http://localhost:9001/api/product",
    contentType: "application/json",
    success: function (productResponse) {
      let productData = productResponse.data;
      productData.forEach((product, index) => {
        tableData += `<tr>
        <td>${index + 1}</td>
        <td>${product.category.name}</td>
        <td>${product.name}</td>
        <td>${product.slug}</td>
        <td>${product.description}</td>
        <td><input type="checkbox" ${product.isDeleted ? "checked" : ""} disabled /></td>
        <td>
            <button class="btn btn-primary" onclick="editForm(${product.id})">Edit</button>
            <button class="btn btn-danger" onclick="deleteForm(${product.id})">Delete</button>
          </td>
        </tr>`;
    });
    // jquery
    $("#productTable").html(tableData);
    },
  });
}
loadData();

function openForm(type) {
  $.ajax({
    type: "get",
    url: "http://localhost:9001/api/category",
    contentType: "application/json",
    success: function (categoryResponse) {
      let categoryData = categoryResponse.data;
      let options = ``;

      categoryData.forEach((category) =>{
        options += `<option value="${category.id}">${category.name}</option>`;
      });
      $('#categoryName').append(options);
    }
  });
  $('categoryName').on('changed', function () {
    $('#categoryId').val(this.value);
  })
  let button = ``;
  if (type == "edit") {
    button += `<button type="submit" class="btn btn-primary" id="editButton" style="float: right;" onclick="editProduct(this.value)">Update</button>`
  } else if (type == "delete") {
    button += `<button class="btn btn-danger" id="deleteButton" style="float: right;" onclick="deleteProduct(this.value)">Delete</button>`
  }else{
    button += `<button type="submit" class="btn btn-primary" id="submitButton" style="float: right;" onclick="saveProduct()">Save</button>`
  }
  $.ajax({
      type: "get",
      url: "/product/form",
      contentType: "html",
      success: function (productForm) {
          $('#myModal').modal('show');
          if(type == "delete"){
            document.querySelector('.modal-title').innerHTML= "Are you sure you want to delete this data ?";
          }else{
            document.querySelector('.modal-title').innerHTML = "Product Form";
          }
          $('.modal-body').html(productForm);

          $('#formButton').append(button);
      }
  });
}

function saveProduct() {
  let jsonData = {
    categoryName : document.getElementById("categoryName").value,
    name: document.getElementById("productName").value,
    slug: document.getElementById("productSlug").value,
    description: document.getElementById("productDesc").value,
    isDeleted: document.getElementById("productDeleted").checked
  }
  $.ajax({
    type: "POST",
    url: "http://localhost:9001/api/product",
    data: JSON.stringify(jsonData),
    contentType: "application/json",
    success: function (response) {
      console.log(response);
      location.reload();
      // location.href='http://localhost:9001/api/category'
    },
    error: function (error) {
      console.log(error);
    }
  });
}

function editForm(id){
  openForm("edit");
  $.ajax({
      type: "get",
      url: `http://localhost:9001/api/product/${id}`,
      contentType: "application/json",
      success: function (response) {
        let productData = response.data[0];

        // document.getElementById('productName').value = productData.name;
        // document.getElementById('productSlug').value = productData.slug;
        // document.getElementById('productDesc').value = productData.description;
        // document.getElementById('productDeleted').checked = productData.isDeleted;
        // document.getElementById('editButton').value = productData.id;

        $('#productName').val(productData.name);
        $('#productSlug').val(productData.slug);
        $('#productDesc').val(productData.description);
        $('#categoryName').val(productData.categoryName);
        $('#productDeleted').prop("checked", productData.isDeleted);
        $('#editButton').val(productData.id);
      }
  });
}

function editProduct(id){
  let jsonData = {
    // name: document.getElementById("productName").value,
    // slug: document.getElementById("productSlug").value,
    // description: document.getElementById("productDesc").value,
    // isDeleted: document.getElementById("productDeleted").checked
    id : $('#productId').val(),
    name: $('#productName').val(),
    slug: $("#productSlug").val(),
    description: $('#productDesc').val(),
    categoryName : $('#categoryName').val(),
    isDeleted: $('#productDeleted').prop("checked")
  }
  $.ajax({
    url: `http://localhost:9001/api/product/${id}`,
    type: "PUT",
    data: JSON.stringify(jsonData),
    contentType: "application/json",
    success: function (response) {
      console.log(response);
      location.reload();
    }
  });
}

function deleteForm(id){
  openForm("delete");
  $.ajax({
      type: "get",
      url: `http://localhost:9001/api/product/${id}`,
      contentType: "application/json",
      success: function (response) {
        let productData = response.data[0];
        // document.getElementById("productName").value = productData.name;
        // document.getElementById("productName").disable = true;
        // document.getElementById("productSlug").value = productData.slug;
        // document.getElementById("productSlug").disable = true;
        // document.getElementById("productDesc").value = productData.description;
        // document.getElementById("productDesc").disable = true;
        // document.getElementById("productDeleted").value = productData.isDeleted;
        // document.getElementById("productDeleted").disable = true;
        // document.getElementById("deleteButton").value = productData.id;

        $('#productName').val(productData.name);
        $('#productName').prop("disabled", true);
        $('#productSlug').val(productData.slug);
        $('#productSlug').prop("disabled", true);
        $('#productDesc').val(productData.description);
        $('#productDesc').prop("disabled", true);
        $('#productDeleted').prop("checked",productData.isDeleted);
        $('#productDeleted').prop("disabled", true);
        $('#deleteButton').val(productData.id);
      }
  });
}

function deleteProduct(id){
  $.ajax({
      type: "delete",
      url: `http://localhost:9001/api/product/${id}`,
      contentType: "application/json",
      success: function (response) {
        console.log(response);
        location.reload();
      }
  });
}