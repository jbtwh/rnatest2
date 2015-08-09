'use strict';

var DownloadController = function($scope, $http) {


    $scope.downloadFile = function() {
        $http.post('download', null, { responseType: 'arraybuffer' })
        .success(function(data) {
            var file = new Blob([data], { type: 'application/xml' });
            saveAs(file, 'doc.xml');
        }).error(function() {
           window.alert("error on download");
        });;
    };


};