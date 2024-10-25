function openForm() {
  $.ajax({
    type: "get",
    url: "/product/form",
    data: "html",
    success: function (productForm) {
      $(`#myModal`).modal(`show`);
      $(`.modal-title`).html("Product Form");
      $(`.modal-body`).html(productForm);
    }
  });
}

function editForm(id) {
  $.ajax({
    type: "get",
    url: `/product/edit/${id}`,
    data: "html",
    success: function (productForm) {
      $(`#myModal`).modal(`show`);
      $(`.modal-title`).html("Product Form");
      $(`.modal-body`).html(productForm);
    }
  });
}

function deleteForm(id) {
  $.ajax({
    type: "get",
    url: `/product/deleteForm/${id}`,
    data: "html",
    success: function (productForm) {
      $(`#myModal`).modal(`show`);
      $(`.modal-title`).html("Product Form");
      $(`.modal-body`).html(productForm);
    }
  });
}

function deleteProduct(id) {
  $.ajax({
    type: "get",
    url: `/product/delete/${id}`,
    success: function () {
      location.reload();
    }
  });
}

$(document).ready(function () {
  $('#categoryId option[value=""]').attr('disabled', true);
});


