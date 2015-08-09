'use strict';


var ListController = function($scope, $http, uiGridConstants) {
var paginationOptions = {
    pageNumber: 1,
    pageSize: 5,
    sort: null
  };

  $scope.gridOptions = {
    paginationPageSizes: [5, 10, 15],
    paginationPageSize: 5,
    useExternalPagination: true,
    useExternalSorting: true,
    enableColumnResize : true,
    columnDefs: [
      { name: 'title', enableSorting: false, width: 160},
      { name: 'artist', enableSorting: false, width: 160 },
      { name: 'country', enableSorting: false },
      { name: 'company', enableSorting: false },
      { name: 'price', enableSorting: false },
      { name: 'year', enableSorting: false },
    ],
    onRegisterApi: function(gridApi) {
      $scope.gridApi = gridApi;
      $scope.gridApi.core.on.sortChanged($scope, function(grid, sortColumns) {
        if (sortColumns.length == 0) {
          paginationOptions.sort = null;
        } else {
          paginationOptions.sort = sortColumns[0].sort.direction;
        }
        getPage();
      });
      gridApi.pagination.on.paginationChanged($scope, function (newPage, pageSize) {
        paginationOptions.pageNumber = newPage;
        paginationOptions.pageSize = pageSize;
        getPage();
      });
    }
  };

  var getPage = function() {
    var url;
    switch(paginationOptions.sort) {
      default:
        url = '/list';
        break;
    }

    $http.get(url)
    .success(function (data) {
      $scope.gridOptions.totalItems = data.length;
      var firstRow = (paginationOptions.pageNumber - 1) * paginationOptions.pageSize;
      $scope.gridOptions.data = data.slice(firstRow, firstRow + paginationOptions.pageSize);
    });
  };

  getPage();
 }
