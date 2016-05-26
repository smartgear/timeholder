/**
 * Created by Administrator on 2016/1/25.
 */
userUrl = {
    "updateUrl": "http://localhost:18080/trymvc/lys/user/update",
    "getUrl": "http://localhost:18080/trymvc/lys/user/get",
    "listUrl": "http://localhost:18080/trymvc/lys/user/list",
    "countUrl": "http://localhost:18080/trymvc/lys/user/count"

}

partnerUrl = {
    "createUrl": "http://localhost:18080/trymvc/lys/parterner/create",
    "updateUrl": "http://localhost:18080/trymvc/lys/parterner/update",
    "getUrl": "http://localhost:18080/trymvc/lys/parterner/get",
    "listUrl": "http://localhost:18080/trymvc/lys/parterner/list",
    "countUrl": "http://localhost:18080/trymvc/lys/parterner/count"

}

giftUrl = {
    "createUrl": "http://localhost:18080/trymvc/lys/gift/create",
    "updateUrl": "http://localhost:18080/trymvc/lys/gift/update",
    "getUrl": "http://localhost:18080/trymvc/lys/gift/get",
    "listUrl": "http://localhost:18080/trymvc/lys/gift/list",
    "countUrl": "http://localhost:18080/trymvc/lys/gift/count"
}

userState={
    "active":"active",
    "disable":"disable"
}

//function updateUser($scope, handleResult) {
//    $.post($scope.updateUrl,
//        {
//            "userId": $scope.user.userId,
//            "username": $scope.user.username,
//            "password": $scope.user.password,
//            "from": "admin",
//            "email": $scope.user.email,
//            "mobile": $scope.user.mobile,
//            "role": $scope.user.role,
//            "state": $scope.user.state,
//            "extid": $scope.user.extid
//        },
//        handleUpdateResult
//    );
//};


function updateUser(user, handleResult) {
    var user
    $.post(userUrl.updateUrl,
        {
            "userId": user.userId,
            "username": user.username,
            "password": user.password,
            "from": user.from,
            "email": user.email,
            "mobile": user.mobile,
            "role": user.role,
            "state": user.state,
            "extid": user.extid
        },
        handleResult
    );
};

function updatePartner(partner, handleResult) {
    var user
    $.post(partnerUrl.updateUrl,
        {
            "id": partner.id,
            "name": partner.name,
            "desc": partner.desc,
            "linkman": partner.linkman,
            "mail": partner.mail,
            "mobile": partner.mobile,
            "telephone": partner.telephone,
            "address": partner.address,
            "category": partner.category
        },
        handleResult
    );
};
