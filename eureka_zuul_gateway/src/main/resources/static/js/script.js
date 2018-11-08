$(function () {

    window.localStorage.setItem("token", "Basic " + btoa("admin:pass"));

    $("#formServiceA").hide();
    $("#formServiceB").hide();
    $("#formAddProduct").hide();
    $("#formDeleteProduct").hide();
    $("#formBuyProduct").hide();
    $("#formFileService").hide();

    $("#serviceA").click(function (event) {
        event.preventDefault();
        $("#formServiceA").show();
        $("#formServiceB").hide();
        $("#formAdminService").hide();
        $("#formFileService").hide();
    });

    $("#serviceB").click(function (event) {
        event.preventDefault();
        $("#formServiceA").hide();
        $("#formServiceB").show();
        $("#formAdminService").hide();
        $("#formFileService").hide();
    });

    $("#getServiceName").click(function (event) {
        event.preventDefault();
        $("#formAddProduct").hide();
        $("#formDeleteProduct").hide();
        $.ajax({
            type: "GET",
            url: "/service",
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            alert(JSON.stringify(data));
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    $("#getPrincipal").click(function (event) {
        event.preventDefault();
        $("#formAddProduct").hide();
        $("#formDeleteProduct").hide();
        $.ajax({
            type: "GET",
            url: "/principal",
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            alert(JSON.stringify(data));
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    $("#getAuth").click(function (event) {
        event.preventDefault();
        $("#formAddProduct").hide();
        $("#formDeleteProduct").hide();
        $.ajax({
            type: "GET",
            url: "/auth",
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            alert(JSON.stringify(data));
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    $("#authInfo").click(function (event) {
        event.preventDefault();
        $("#formAddProduct").hide();
        $("#formDeleteProduct").hide();
        $.ajax({
            type: "GET",
            url: "/service/A/auth",
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            var auth = data;
            $("#allProducts").empty();
            $("#result").empty();
            $("#result").append("<div><label>Authorities: " + JSON.stringify(auth.authorities) + "</label><br/>" +
                "<label>UserName: " + auth.username + "</label><br/>" +
                "<label>ACCOUNTNONLOCKED: " + auth.accountNonLocked + "</label><br/>" +
                "<label>ACCOUNTNONEXPIRED: " + auth.accountNonExpired + "</label><br/>" +
                "<label>CREDENTIALSNONEXPIRED: " + auth.credentialsNonExpired + "</label></div>");
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    $("#serviceName").click(function (event) {
        event.preventDefault();
        $("#formAddProduct").hide();
        $("#formDeleteProduct").hide();
        $.ajax({
            type: "GET",
            url: "/service/A/service",
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            $("#allProducts").empty();
            $("#result").text("Service: " + JSON.stringify(data));
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    $("#getAllProducts").click(function (event) {
        event.preventDefault();
        $("#formAddProduct").hide();
        $("#formDeleteProduct").hide();
        $.ajax({
            type: "GET",
            url: "/service/A/products/all",
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            var products = data;
            $("#allProducts").empty();
            $("#result").empty();
            for (var i = 0; i < products.length; i++)
                $("#allProducts").append("<div>" +
                    "<label>" + products[i].productName + "</label><br/>" +
                    "<label>" + products[i].productPrice + "</label><br/>" +
                    "<label>" + products[i].productDescription + "</label></div><hr/>")
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    $("#addProduct").click(function (event) {
        event.preventDefault();
        $("#formAddProduct").show();
        $("#allProducts").empty();
        $("#result").empty();
        $("#formDeleteProduct").hide();
    });

    $("#addProductBtn").click(function (event) {
        event.preventDefault();
        var data = {
            productName: $("#productName").val(),
            productPrice: $("#productPrice").val(),
            productDescription: $("#productDescription").val()
        };
        $.ajax({
            type: "POST",
            url: "/service/A/products/add",
            dataType: 'json',
            data: JSON.stringify(data),
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            alert(JSON.stringify(data));
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    $("#deleteProduct").click(function (event) {
        event.preventDefault();
        $("#formAddProduct").hide();
        $("#allProducts").empty();
        $("#result").empty();
        $("#formDeleteProduct").show();
        $.ajax({
            type: "GET",
            url: "/service/A/products/all",
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            var products = data;
            $("#allProducts").empty();
            $("#result").empty();
            $("#listProducts").empty();
            for (var i = 0; i < products.length; i++)
                $("#listProducts").append("<option value='" + products[i].productName + "'/>");
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    $("#deleteProductBtn").click(function (event) {
        event.preventDefault();
        $.ajax({
            type: "DELETE",
            url: "/service/A/products/delete/" + $("#productNameForDeleting").val(),
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            alert(JSON.stringify(data));
            $("#formDeleteProduct").hide();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    $("#getProductsForBuying").click(function (event) {
        event.preventDefault();
        $("#formBuyProduct").hide();
        $.ajax({
            type: "GET",
            url: "/service/B/products/all",
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            var products = data;
            $("#allBuyingProducts").empty();
            for (var i = 0; i < products.length; i++)
                $("#allBuyingProducts").append("<div>" +
                    "<label>" + products[i].productName + "</label><br/>" +
                    "<label>" + products[i].productPrice + "</label><br/>" +
                    "<label>" + products[i].productDescription + "</label></div><hr/>")
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    $("#getProductsBuying").click(function (event) {
        event.preventDefault();
        $("#formBuyProduct").hide();
        $.ajax({
            type: "GET",
            url: "/service/B/products/buckets/all",
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            var products = data;
            $("#allBuyingProducts").empty();
            for (var i = 0; i < products.length; i++)
                $("#allBuyingProducts").append("<div>" +
                    "<label>" + products[i].productName + "</label><br/>" +
                    "<label>" + products[i].productPrice + "</label><br/>" +
                    "<label>" + products[i].productDescription + "</label></div><hr/>")
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    $("#buyProduct").click(function (event) {
        event.preventDefault();
        $("#formBuyProduct").show();
        $.ajax({
            type: "GET",
            url: "/service/B/products/all",
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            var products = data;
            $("#allBuyingProducts").empty();
            $("#listProducts").empty();
            for (var i = 0; i < products.length; i++)
                $("#listProducts").append("<option value='" + products[i].productName + "'/>");
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    })

    $("#buyProductBtn").click(function (event) {
        event.preventDefault();
        $.ajax({
            type: "PUT",
            url: "/service/B/products/buckets/add/" + $("#productNameForBuying").val(),
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            },
            timeout: 1000
        }).done(function (data) {
            alert(JSON.stringify(data));
            $("#formBuyProduct").hide();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });


    $("#test").click(function (event) {
        event.preventDefault();
        $.ajax({
            type: "GET",
            url: "/service/A/test",
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            alert(JSON.stringify(data));
        }).fail(function (qXHR, textStatus, errorThrown) {
            console.log('request: ', qXHR);
            console.log('status text: ', textStatus);
            console.log('thrown error: ', JSON.stringify(errorThrown));
        });
    });

    $("#fileBtn").click(function (event) {
        event.preventDefault();
        $("#formFileService").load("fileService.html");
        $("#formFileService").show();
        $("#formServiceA").hide();
        $("#formServiceB").hide();
        $("#formAdminService").hide();
    });

    $("#token").prop("disabled", true);
    $("#token").prop("hidden", true);

    $("#btnSubmit").click(function (event) {
        event.preventDefault();
        var form = $('#fileUploadForm')[0];
        var data = new FormData(form);
        data.append("CustomField", "This is some extra data, testing");
        $("#btnSubmit").prop("disabled", true);
        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "/file/api/upload/multi",
            data: data,
            processData: false, //prevent jQuery from automatically transforming the data into a query string
            contentType: false,
            cache: false,
            timeout: 600000
        }).done(function (data) {
            var temp = data;
            $("#resultFileBtn").html(JSON.stringify(data));
            console.log("SUCCESS : ", data);
            $("#btnSubmit").prop("disabled", false);
            var copyText = temp.token;
            copyText.select();
            document.execCommand("copy");
        }).fail(function (e) {
            $("#result").html(e.responseText);
            console.log("ERROR : ", e);
            $("#btnSubmit").prop("disabled", false);
        });
    });

    $('#downloadBtn').click(function (event) {
        var tokenKey = $('#tokenKey').val();
        event.preventDefault();
        window.location.replace("http://localhost:8762/file/api/download/" + tokenKey);
    });

    $("#formCreate").hide();
    $("#formChange").hide();
    $("#formOpportunity").hide();
    $("#formCreateAccess").hide();
    $("#formGetAccess").hide();

    $("#add").click(function (event) {
        event.preventDefault();
        $("#formAdminService").show();
        $("#formServiceA").hide();
        $("#formServiceB").hide();
        $("#formFileService").hide();
        $("#formCreate").show();
        $("#formChange").hide();
        $("#formOpportunity").hide();
        $("#formCreateAccess").hide();
        $("#formGetAccess").hide();
        $.ajax({
            type: "GET",
            url: "/admin/tool/roles",
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            var roles = data;
            $('#listRolesId').empty();
            for (var j = 0; j < roles.length; j++)
                $('#listRolesId').append(
                    "<div class='row'>" +
                    "<div class='col-2'>" +
                    "<input type='checkbox' name='roles' value='" + roles[j] + "'/>" +
                    "</div><div class='col'>" +
                    "<label id='j'>" + roles[j] + "</label>" +
                    "</div>" +
                    "</div>");
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    $("#delete").click(function (event) {
        event.preventDefault();
        $("#formAdminService").show();
        $("#formCreate").hide();
        $("#formChange").show();
        $("#formOpportunity").hide();
        $("#formCreateAccess").hide();
        $("#formGetAccess").hide();
        $("#formServiceA").hide();
        $("#formServiceB").hide();
        $("#formFileService").hide();
    });

    $("#setAccess").click(function (event) {
        event.preventDefault();
        $("#formAdminService").show();
        $("#formCreate").hide();
        $("#formChange").hide();
        $("#formOpportunity").show();
        $("#formCreateAccess").hide();
        $("#formGetAccess").hide();
        $("#formServiceA").hide();
        $("#formServiceB").hide();
        $("#formFileService").hide();
        $.ajax({
            type: "GET",
            url: "/admin/tool/opportunities",
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            var opportunities = data;
            $('#opportunities').empty();
            for (var j = 0; j < opportunities.length; j++)
                $('#opportunities').append("<div class='row'>" +
                    "<div class='col-2'>" +
                    "<input type='checkbox' name='opportunity' value='" + opportunities[j].accessName + "'/>" +
                    "</div>" +
                    "<div class='col'>" +
                    "<label id='j'>" + opportunities[j].accessName + "</label>" +
                    "</div>" +
                    "</div>");
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
        $.ajax({
            type: "GET",
            url: "/admin/tool/roles",
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            var roles = data;
            $('#listRoles').empty();
            for (var j = 0; j < roles.length; j++)
                $('#listRoles').append("<option value='" + roles[j] + "'/>");
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    $("#radioDetail").click(function () {
        $.ajax({
            type: "GET",
            url: "/admin/tool/get/detail",
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            var listDetailInfo = data;
            $('#listOpportunities').empty();
            for (var j = 0; j < listDetailInfo.length; j++)
                $('#listOpportunities').append("<option value='" + listDetailInfo[j] + "'/>");
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    $("#radioUsername").click(function () {
        $.ajax({
            type: "GET",
            url: "/admin/tool/get/login",
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            var listLogins = data;
            $('#listOpportunities').empty();
            for (var j = 0; j < listLogins.length; j++)
                $('#listOpportunities').append("<option value='" + listLogins[j] + "'/>");
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    $("#deleteBtn").click(function (event) {
        event.preventDefault();
        var urlSearching;

        if ($('[id="radioUsername"]').is(':checked'))
            urlSearching = "/admin/tool/delete/login/" + $("#searchingValue").val();
        else urlSearching = "/admin/tool/delete/name/" + $("#searchingValue").val();

        $.ajax({
            type: "DELETE",
            url: urlSearching,
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            console.log(data);
            $("#formChange").hide();
            alert("SUCCESS!");
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    $("#createUser").click(function (event) {
        event.preventDefault();
        var roles = [];
        $.each($("input[name='roles']:checked"), function () {
            roles.push($(this).val());
        });
        if ($("#pass1").val() === $("#pass2").val()) {
            var data = {
                userUserName: $("#name").val(),
                userCredentialsLogin: $("#login").val(),
                userCredentialsPassword: $("#pass1").val(),
                userRoles: roles
            };
            $.ajax({
                type: "POST",
                url: "/admin/tool/add",
                dataType: 'json',
                data: JSON.stringify(data),
                contentType: 'application/json',
                headers: {
                    "Authorization": window.localStorage.getItem("token")
                }
            }).done(function (data) {
                console.log(JSON.stringify(data));
                alert("SUCCESS!");
                $("#formCreate").hide();
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        } else alert("Wrong confirm password.")
    });

    $("#grantOpportunities").click(function (event) {
        event.preventDefault();
        var opportunities = [];
        $.each($("input[name='opportunity']:checked"), function () {
            opportunities.push($(this).val());
        });

        var data = {
            roleName: $("#role").val(),
            accesses: opportunities
        };
        $.ajax({
            type: "PUT",
            url: "/admin/tool/grant",
            dataType: 'json',
            data: JSON.stringify(data),
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            console.log(JSON.stringify(data));
            alert("SUCCESS!");
            $("#formOpportunity").hide();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    $("#addAccess").click(function (event) {
        event.preventDefault();
        $("#formAdminService").show();
        $("#formCreate").hide();
        $("#formChange").hide();
        $("#formOpportunity").hide();
        $("#formCreateAccess").show();
        $("#formGetAccess").hide();
        $("#formServiceA").hide();
        $("#formServiceB").hide();
        $("#formFileService").hide();
        $.ajax({
            type: "GET",
            url: "/admin/tool/services",
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            var listServices = data;
            $('#listServices').empty();
            for (var j = 0; j < listServices.length; j++)
                $('#listServices').append("<option value='" + listServices[j] + "'/>");
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
        $.ajax({
            type: "GET",
            url: "/admin/tool/types",
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            var listTypesAccesses = data;
            $('#listTypesAccess').empty();
            for (var j = 0; j < listTypesAccesses.length; j++)
                $('#listTypesAccess').append("<option value='" + listTypesAccesses[j] + "'/>");
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    $("#createAccess").click(function (event) {
        event.preventDefault();
        var data = {
            nameAccess: $("#nameAccess").val(),
            nameService: $("#services").val(),
            typeAccess: $("#typesAccesses").val()
        };
        $.ajax({
            type: "POST",
            url: "/admin/tool/addAccess",
            dataType: 'json',
            data: JSON.stringify(data),
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            console.log(JSON.stringify(data));
            alert("SUCCESS!");
            $("#formCreateAccess").hide();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    $("#allAccesses").click(function (event) {
        event.preventDefault();
        $("#formAdminService").show();
        $("#formCreate").hide();
        $("#formChange").hide();
        $("#formOpportunity").hide();
        $("#formCreateAccess").hide();
        $("#formGetAccess").show();
        $("#formServiceA").hide();
        $("#formServiceB").hide();
        $("#formFileService").hide();
        $.ajax({
            type: "GET",
            url: "/admin/tool/roles",
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            var roles = data;
            $('#listRoles').empty();
            for (var j = 0; j < roles.length; j++)
                $('#listRoles').append("<option value='" + roles[j] + "'/>");
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    });

    $("#findAccess").click(function (event) {
        event.preventDefault();
        $.ajax({
            type: "GET",
            url: "/admin/tool/access/" + $("#roleNameFormGetAccess").val(),
            contentType: 'application/json',
            headers: {
                "Authorization": window.localStorage.getItem("token")
            }
        }).done(function (data) {
            var accesses = data;
            $('#accesses').empty();
            for (var j = 0; j < accesses.length; j++)
                $('#accesses').append("<h6 style='color: #FF338D; text-transform: uppercase'>" + accesses[j].accessName + "</h6>" +
                    "<h8 style='color: #6E717C'>Service: <label>" + accesses[j].tservice.service + "</label></h8><br/>" +
                    "<h8 style='color: #6E717C'>Type access: <label>" + accesses[j].typeAccess.access + "</label></h8><hr/>");
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    })
})