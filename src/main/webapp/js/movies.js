var myApp = angular.module('myApp',['ngRoute', 'ngResource']);

myApp.config(function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: '/main.html' })
        .when('/movies', {
            templateUrl: '/movies.html',
            controller: 'MoviesCtrl'})
        .when('/common', {
            templateUrl: 'common.html' })
        .otherwise({ redirectTo: '/'})
});

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

}]);

myApp.controller('MoviesCtrl', ['$scope', '$http', function($scope, $http) {
    $http.get('http://localhost:8081/cine/rest/movies/movielist').then(function(movList) {
        $scope.movieList = movList.data;
    })
}]);




