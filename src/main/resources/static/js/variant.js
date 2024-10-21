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

$(document).ready(function() {
  $('#categoryId option[value=""]').attr('disabled', true);
  $('#productId option[value=""]').attr('disabled', true);
});


