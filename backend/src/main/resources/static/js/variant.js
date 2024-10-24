function openForm() {
  $.ajax({
    type: "get",
    url: "/variant/form",
    data: "html",
    success: function (variantForm) {
      $(`#myModal`).modal(`show`);
      $(`.modal-title`).html("Variant Form");
      $(`.modal-body`).html(variantForm);
    }
  });
}

function editForm(id) {
  $.ajax({
    type: "get",
    url: `/variant/edit/${id}`,
    data: "html",
    success: function (variantForm) {
      $(`#myModal`).modal(`show`);
      $(`.modal-title`).html("Variant Form");
      $(`.modal-body`).html(variantForm);
    }
  });
}

function deleteForm(id) {
  $.ajax({
    type: "get",
    url: `/variant/deleteForm/${id}`,
    data: "html",
    success: function (variantForm) {
      $(`#myModal`).modal(`show`);
      $(`.modal-title`).html("Variant Form");
      $(`.modal-body`).html(variantForm);
    }
  });
}

function deleteVariant(id) {
  $.ajax({
    type: "get",
    url: `/variant/delete/${id}`,
    success: function () {
      location.reload();
    }
  });
}

// document.addEventListener("DOMContentLoaded", function () {
//   let categoryIdOptions = document.querySelectorAll()
// });

$(document).ready(function() {
  $('#categoryId option[value=""]').attr('disabled', true);
  $('#productId option[value=""]').attr('disabled', true);
});

// function updateProduct(categoryId){
//   $.ajax({
//       type: "get",
//       url: `/variant/products-by-category/${categoryId}`,
//       success: function(products) {
//           const productSelect = document.getElementById("productId");
//           productSelect.innerHTML = '<option selected disabled value="">Select Product</option>';

//           products.forEach(product => {
//               const newOption = document.createElement("option");
//               newOption.value = product.id;
//               newOption.text = product.name;
//               productSelect.appendChild(newOption);
//           });
//       },
//       error: function(error) {
//           console.error('Error fetching products:', error);
//       }
//   });

// }

