$(function () {

    $("#formCreate").hide();
    $("#formChange").hide();
    $("#formOpportunity").hide();
    $("#formCreateAccess").hide();
    $("#formGetAccess").hide();

    $("#add").click(function (event) {
        event.preventDefault();
        $("#formCreate").show();
        $("#formChange").hide();
        $("#formOpportunity").hide();
        $("#formCreateAccess").hide();
        $("#formGetAccess").hide();
        $.ajax({
            type: "GET",
            url: "/admin/tool/roles",
            contentType: 'application/json'
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
        $("#formCreate").hide();
        $("#formChange").show();
        $("#formOpportunity").hide();
        $("#formCreateAccess").hide();
        $("#formGetAccess").hide();
    });

    $("#setAccess").click(function (event) {
        event.preventDefault();
        $("#formCreate").hide();
        $("#formChange").hide();
        $("#formOpportunity").show();
        $("#formCreateAccess").hide();
        $("#formGetAccess").hide();
        $.ajax({
            type: "GET",
            url: "/admin/tool/opportunities",
            contentType: 'application/json'
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
            contentType: 'application/json'
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
            contentType: 'application/json'
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
            contentType: 'application/json'
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
            contentType: 'application/json'
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
                contentType: 'application/json'
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
            contentType: 'application/json'
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
        $("#formCreate").hide();
        $("#formChange").hide();
        $("#formOpportunity").hide();
        $("#formCreateAccess").show();
        $("#formGetAccess").hide();
        $.ajax({
            type: "GET",
            url: "/admin/tool/services",
            contentType: 'application/json'
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
            contentType: 'application/json'
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
            contentType: 'application/json'
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
        $("#formCreate").hide();
        $("#formChange").hide();
        $("#formOpportunity").hide();
        $("#formCreateAccess").hide();
        $("#formGetAccess").show();
        $.ajax({
            type: "GET",
            url: "/admin/tool/roles",
            contentType: 'application/json'
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
            contentType: 'application/json'
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
});
