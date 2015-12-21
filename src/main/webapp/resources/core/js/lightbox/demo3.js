angular.module('demo3', ['bootstrapLightbox']);

angular.module('demo3').config(function (LightboxProvider) {
  // set a custom template
  LightboxProvider.templateUrl = 'demo3-lightbox-modal.html';
});

angular.module('demo3').controller('AppCtrl', function ($scope, Lightbox) {
  $scope.images = [
    {
      'url': 'http://36.media.tumblr.com/e6e96416615c042dbb05557e2553e727/tumblr_nh09woLkmb1sfie3io1_1280.jpg',
    },
    {
      'url': 'http://41.media.tumblr.com/bdcdc7cfcd7ec9615056f2bc6917a797/tumblr_nh09wjQHwu1sfie3io1_1280.jpg',
    },
    {
      'url': 'http://40.media.tumblr.com/ea6f19f50cc563c29a6596cc2e247e8c/tumblr_ngt0z90G0L1sfie3io1_1280.jpg',
    },
    {
      'url': 'http://41.media.tumblr.com/33434e6b27e36033cdcc8fd1fda5cfad/tumblr_ngt0yotJNk1sfie3io1_1280.jpg',
    },
    {
      'url': 'http://40.media.tumblr.com/665d08fd73c3e5749a031d2aacf089a2/tumblr_ngotbehUG41sfie3io1_1280.jpg',
    },
    {
      'url': 'http://40.media.tumblr.com/e364a90450ef6559bfcd6a18fbb38d02/tumblr_ngotb4IY8v1sfie3io1_1280.jpg',
    },
    {
      'url': 'http://41.media.tumblr.com/e16c7dc453a76c5df1df6284f8d56858/tumblr_ngotb0IzPM1sfie3io1_1280.jpg',
    },
    {
      'url': 'http://40.media.tumblr.com/59ca3529cadfcfbbcf8de154ffd613c8/tumblr_ngotatAiLG1sfie3io1_1280.jpg'
    }
  ];

  $scope.openLightboxModal = function (images) {
    Lightbox.openModal(images, 0);
  };
});

// custom lightbox controller
angular.module('demo3').controller('LightboxCtrl', function ($scope, $window) {
  $scope.alert = function (message) {
    $window.alert(message);
  };
});