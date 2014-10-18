var myApp = angular.module('myApp',['ngResource']);

myApp.controller('MovieCtrl', ['$scope', '$http', '$location', function($scope, $http, $location) {
    //movieController = {};
    $scope.movieId = {};
    $scope.newData = {};
    $scope.loadMovie = function(id) {
        $scope.movieId = id;
        $http({
            url: 'http://localhost:8081/cine/rest/movies/' + id,
            method: 'GET'
        }).success(function(data){
            $scope.newData = data;
        })

    };

//    movieController.loadMovie = function (id, $scope, $http) {
//        $scope.movieId = angular.copy(id);
//        $http.get('http://localhost:8081/cine/rest/movies/' + $scope.id)
//            success(function(data) {
//                $scope.movie = data;
//            });
//    }
}]);

myApp.controller('MoviesCtrl', ['$scope', '$http', function($scope, $http) {
    $http.get('http://localhost:8081/cine/rest/movies/movielist').then(function(movList) {
        $scope.movieList = movList.data;
    })

}]);
