loadData();
function loadData() {
  let tableData=``;
  $.ajax({
    type: "get",
    url: "http://localhost:9001/api/variant",
    contentType: "application/json",
    success: function (variantResponse) {
      let variantData = variantResponse.data;
      
      variantData.forEach((variant, index) => {
        tableData += `<tr>
        <td>${index + 1}</td>
        <td>${variant.product.category.name} / ${variant.product.name}</td>
        <td>${variant.name}</td>
        <td>${variant.slug}</td>
        <td>${variant.description}</td>
        <td>${variant.price}</td>
        <td>${variant.stock}</td>
        <td><input type="checkbox" ${variant.isDeleted ? "checked" : ""} disabled /></td>
        <td>
            <button class="btn btn-primary" onclick="editForm(${variant.id})">Edit</button>
            <button class="btn btn-danger" onclick="deleteForm(${variant.id})">Delete</button>
          </td>
        </tr>`;
    });
    // jquery
    $("#variantTable").html(tableData);
    },
  });
}


function openForm(type) {
  
  let button = ``;
  if (type == "edit") {
    button += `<button type="submit" class="btn btn-primary" id="editButton" style="float: right;" onclick="editVariant(this.value)">Update</button>`
  } else if (type == "delete") {
    button += `<button class="btn btn-danger" id="deleteButton" style="float: right;" onclick="deleteVariant(this.value)">Delete</button>`
  }else{
    button += `<button type="submit" class="btn btn-primary" id="submitButton" style="float: right;" onclick="saveVariant()">Save</button>`
  }
  
  // load data categories
  $.ajax({
    type: "get",
    url: "http://localhost:9001/api/category",
    contentType: "application/json",
    success: function (categoryResponse) {
      let categoryData = categoryResponse.data;
      let options = ``;
      options += `<option selected="true" disabled="true" value="">Select Category</option>`
      categoryData.forEach((category) =>{
        options += `<option value="${category.id}">${category.name}</option>`;
      });
      $('#categoryId').append(options);
    }
  });

  $.ajax({
    type: "get",
    url: "/variant/form",
    contentType: "html",
      success: function (variantForm) {
          $('#myModal').modal('show');
          if(type == "delete"){
            document.querySelector('.modal-title').innerHTML= "Are you sure you want to delete this data ?";
          }else{
            document.querySelector('.modal-title').innerHTML = "Variant Form";
          }
          $('.modal-body').html(variantForm);

          $('#formButton').append(button);
      }
  });
}

function updateProduct(){
  const productSelect = $('#productId');
  
  productSelect.empty();
  productSelect.prop('disabled', false);
  $.ajax({
    type: "get",
    url: "http://localhost:9001/api/product",
    contentType: "application/json",
    success: function (productResponse) {
    let productData = productResponse.data;
    let options = `<option selected="true" disabled="true" value=0>Select Product</option>`;
    let selectedCategory = $('#categoryId').val();

    productData.forEach((product) =>{
    if(selectedCategory == product.category.id){
      options += `<option value="${product.id}">${product.name}</option>`;
    }
  });
  $('#productId').append(options);
}
});
}

function saveVariant() {
  // memastikan nilai categoryId diambil sebelum di masukan ke dalam 
  // data Json
  // let categoryId = $('#categoryId').val();
  let productId = $('#productId').val();
  let jsonData = {
    name: $('#variantName').val(),
    slug: $('#variantSlug').val(),
    description: $('#variantDesc').val(),
    isDeleted: $('#variantDeleted').prop("checked"),
    price: $('#variantPrice').val(),
    stock: $('#variantStock').val(),
    productId: productId
  }
  $.ajax({
    type: "POST",
    url: "http://localhost:9001/api/variant",
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
      url: `http://localhost:9001/api/variant/${id}`,
      contentType: "application/json",
      success: function (response) {
        let variantData = response.data[0];
        
        let options = `<option value="${variantData.product.id}">${variantData.product.name}</option>`;
        $('#productId').append(options);
        $('#productId').prop("disabled", false);

        $('#productId').val(variantData.product.id);
        $('#categoryId').val(variantData.product.category.id);
        $('#variantName').val(variantData.name);
        $('#variantSlug').val(variantData.slug);
        $('#variantDesc').val(variantData.description);
        $('#variantPrice').val(variantData.price);
        $('#variantStock').val(variantData.stock);
        $('#variantDeleted').prop("checked", variantData.isDeleted);
        $('#editButton').val(variantData.id);
      }
  });
}

function editVariant(id){
  
  let jsonData = {
    name: $('#variantName').val(),
    slug: $('#variantSlug').val(),
    description: $('#variantDesc').val(),
    isDeleted: $('#variantDeleted').prop("checked"),
    price: $('#variantPrice').val(),
    stock: $('#variantStock').val(),
    productId: $('#productId').val()
  }
  console.log(jsonData);
  
  $.ajax({
    url: `http://localhost:9001/api/variant/${id}`,
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
      url: `http://localhost:9001/api/variant/${id}`,
      contentType: "application/json",
      success: function (response) {
        let variantData = response.data[0];

        let options = `<option value="${variantData.product.id}">${variantData.product.name}</option>`;
        $('#productId').append(options);

        $('#productId').val(variantData.product.id);
        $('#productId').prop("disabled", true);
        $('#categoryId').val(variantData.product.category.id);
        $('#categoryId').prop("disabled", true);
        $('#variantName').val(variantData.name);
        $('#variantName').prop("disabled", true);
        $('#variantSlug').val(variantData.slug);
        $('#variantSlug').prop("disabled", true);
        $('#variantDesc').val(variantData.description);
        $('#variantDesc').prop("disabled", true);
        $('#variantPrice').val(variantData.price);
        $('#variantPrice').prop("disabled", true);
        $('#variantStock').val(variantData.stock);
        $('#variantStock').prop("disabled", true);
        $('#variantDeleted').prop("checked",variantData.isDeleted);
        $('#variantDeleted').prop("disabled", true);
        $('#deleteButton').val(variantData.id);
      }
  });
}

function deleteVariant(id){
  $.ajax({
      type: "delete",
      url: `http://localhost:9001/api/variant/${id}`,
      contentType: "application/json",
      success: function (response) {
        console.log(response);
        location.reload();
      }
  });
}