function deleteForm() {
  $.ajax({
    type: "get",
    url: `/variant/deleteForm/${id}`,
    data: "html",
    success: function (orderForm) {
      $(`#myModal`).modal(`show`);
      $(`.modal-title`).html("Order Form");
      $(`.modal-body`).html(orderForm);
    }
  });
}

function deleteOrder(id) {
  $.ajax({
    type: "get",
    url: `/order/delete/${id}`,
    data: "data",
    dataType: "dataType",
    success: function () {
      location.reload();
    }
  });
}