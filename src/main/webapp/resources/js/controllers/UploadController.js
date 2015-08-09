'use strict';

var UploadController = function($scope, $http) {


    $scope.uploadFile = function() {
            var file = $scope.myFile;
            if (file!=null && (/\.(xml)$/i).test( file.name )){
                var uploadUrl = "/upload";
                var fd = new FormData();
                fd.append('file', file);
                $http.post(uploadUrl, fd, {
                transformRequest : angular.identity,
                            headers : {
                                'Content-Type' : undefined
                            }
                        }).success(function() {
                            window.alert("successfully uploaded");
                        }).error(function(response) {
                            window.alert("error on upload");
                        });
            }

    };

};