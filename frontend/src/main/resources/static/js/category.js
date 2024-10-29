function loadData() {
  let tableData=``;
  $.ajax({
    type: "get",
    url: "http://localhost:9001/api/category",
    contentType: "application/json",
    success: function (categoryResponse) {
      let categoryData = categoryResponse.data;
      
      categoryData.forEach((category, index) => {
        let isDeleted = category.isDeleted ? "checked" : "";
        tableData += `<tr>
        <td>${index + 1}</td>
        <td>${category.name}</td>
        <td>${category.slug}</td>
        <td>${category.description}</td>
        <td><input type="checkbox" ${category.isDeleted ? "checked" : ""} disabled /></td>
        <td>
            <button class="btn btn-primary" onclick="editForm(${category.id})">Edit</button>
            <button class="btn btn-danger" onclick="deleteForm(${category.id})">Delete</button>
          </td>
        </tr>`;
    });
    // jquery
    $("#categoryTable").html(tableData);

    // Vanilla js
    // document.getElementById("categoryTable").innerHTML = tableData;
    },
  });
}
loadData();

function openForm(type) {
  let button = ``;
  if (type == "edit") {
    button += `<button type="submit" class="btn btn-primary" id="editButton" style="float: right;" onclick="editCategory(this.value)">Update</button>`
  } else if (type == "delete") {
    button += `<button class="btn btn-danger" id="deleteButton" style="float: right;" onclick="deleteCategory(this.value)">Delete</button>`
  }else{
    button += `<button type="submit" class="btn btn-primary" id="submitButton" style="float: right;" onclick="saveCategory()">Save</button>`
  }
  $.ajax({
      type: "get",
      url: "/category/form",
      contentType: "html",
      success: function (categoryForm) {
          $('#myModal').modal('show');
          if(type == "delete"){
            document.querySelector('.modal-title').innerHTML= "Are you sure you want to delete this data ?";
          }else{
            document.querySelector('.modal-title').innerHTML = "Category Form";
          }
          // document.querySelector('.modal-body').innerHTML = categoryForm;
          $('.modal-body').html(categoryForm);

          
          // document.getElementById("formButton").appendChild(button);
          $('#formButton').append(button);
      }
  });
}

function saveCategory() {
  let jsonData = {
    name: document.getElementById("categoryName").value,
    slug: document.getElementById("categorySlug").value,
    description: document.getElementById("categoryDesc").value,
    isDeleted: document.getElementById("categoryDeleted").checked
  }
  $.ajax({
    type: "POST",
    url: "http://localhost:9001/api/category",
    data: JSON.stringify(jsonData),
    contentType: "application/json",
    success: function (response) {
      console.log(response);
      location.reload();
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
      url: `http://localhost:9001/api/category/${id}`,
      contentType: "application/json",
      success: function (response) {
        let categoryData = response.data[0];

        // document.getElementById('categoryName').value = categoryData.name;
        // document.getElementById('categorySlug').value = categoryData.slug;
        // document.getElementById('categoryDesc').value = categoryData.description;
        // document.getElementById('categoryDeleted').checked = categoryData.isDeleted;
        // document.getElementById('editButton').value = categoryData.id;

        $('#categoryName').val(categoryData.name);
        $('#categorySlug').val(categoryData.slug);
        $('#categoryDesc').val(categoryData.description);
        $('#categoryDeleted').prop("checked", categoryData.isDeleted);
        $('#editButton').val(categoryData.id);
      }
  });
}

function editCategory(id){
  let jsonData = {
    // name: document.getElementById("categoryName").value,
    // slug: document.getElementById("categorySlug").value,
    // description: document.getElementById("categoryDesc").value,
    // isDeleted: document.getElementById("categoryDeleted").checked
    id : $('#categoryId').val(),
    name: $('#categoryName').val(),
    slug: $("#categorySlug").val(),
    description: $('#categoryDesc').val(),
    isDeleted: $('#categoryDeleted').prop("checked")
  }
  $.ajax({
    url: `http://localhost:9001/api/category/${id}`,
    type: "PUT",
    data: JSON.stringify(jsonData),
    contentType: "application/json",
    success: function (response) {
      console.log(response);
      location.reload();
      // location.href='http://localhost:9001/api/category'
    }
  });
}

function deleteForm(id){
  openForm("delete");
  $.ajax({
      type: "get",
      url: `http://localhost:9001/api/category/${id}`,
      contentType: "application/json",
      success: function (response) {
        let categoryData = response.data[0];
        // document.getElementById("categoryName").value = categoryData.name;
        // document.getElementById("categoryName").disable = true;
        // document.getElementById("categorySlug").value = categoryData.slug;
        // document.getElementById("categorySlug").disable = true;
        // document.getElementById("categoryDesc").value = categoryData.description;
        // document.getElementById("categoryDesc").disable = true;
        // document.getElementById("categoryDeleted").value = categoryData.isDeleted;
        // document.getElementById("categoryDeleted").disable = true;
        // document.getElementById("deleteButton").value = categoryData.id;

        $('#categoryName').val(categoryData.name);
        $('#categoryName').prop("disabled", true);
        $('#categorySlug').val(categoryData.slug);
        $('#categorySlug').prop("disabled", true);
        $('#categoryDesc').val(categoryData.description);
        $('#categoryDesc').prop("disabled", true);
        $('#categoryDeleted').prop("checked",categoryData.isDeleted);
        $('#categoryDeleted').prop("disabled", true);
        $('#deleteButton').val(categoryData.id);
      }
  });
}

function deleteCategory(id){
  $.ajax({
      type: "delete",
      url: `http://localhost:9001/api/category/${id}`,
      contentType: "application/json",
      success: function (response) {
        console.log(response);
        location.reload();
      }
  });
}