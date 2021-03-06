var memberApp = angular.module('memberApp');
memberApp.config(function ($routeProvider, $locationProvider) {
    //防止路由地址出现感叹号和乱码
    $locationProvider.hashPrefix('');
    $routeProvider
    .when(
        '/home',
        {
            templateUrl: 'view/home.html',
            controller: 'homeCtrl'
        }
    ).when(
        '/commentPage',
        {
            templateUrl: 'view/comments.html',
            controller: 'commentsCtrl'
        }
    ).when(
        '/collections',
        {
            templateUrl: 'view/collections.html',
            controller: 'collectionsCtrl'
        }
    ).when(
        '/collection/:id',
        {
            templateUrl: 'view/collection.html',
            controller: 'collectionCtrl'
        }
    ).when(
        '/sendmail/:orgId/:orgName',
        {
            templateUrl: 'view/sendmail.html',
            controller: 'mailCtrl'
        }
    ).when(
        '/profile',
        {
            templateUrl: 'view/profile.html',
            controller: 'profileCtrl'
        }
    ).when(
        '/notify',
        {
            templateUrl: 'view/notify.html',
            controller: 'notifyCtrl'
        }
    ).when(
        '/mailDetail/:index',
        {
            templateUrl: 'view/mailDetail.html',
            controller: 'mailDetailCtrl'
        }
    ).otherwise(
        {
            redirectTo: '/home'
        }
    )
});