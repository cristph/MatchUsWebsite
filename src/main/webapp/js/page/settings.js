$(function () {
    function User() {
        this.username = ko.observable();
        this.university = ko.observable();
        this.major = ko.observable();
        this.address = ko.observable();
        this.skills = ko.observableArray([]);
        this.birthday = ko.observable();
        this.introduction = ko.observable();
    }

    function UserSettingsBasicViewModel() {
        var self = this;
        self.username = ko.observable();
        self.university = ko.observable();
        self.major = ko.observable();
        self.address = ko.observable();
        self.skills = ko.observableArray([]);
        self.birthday = ko.observable();
        self.introduction = ko.observable();

        $.get("/user/settings/basic", null, function (data) {
            var new_user = data;
            self.username(new_user.username);
            self.university(new_user.university);
            self.major(new_user.major);
            self.address(new_user.address);
            self.skills(new_user.skills);
            self.birthday(new_user.birthday);
            self.introduction(new_user.introduction);
        })
        self.update = function () {
            $.post("/user/settings/basic", {
                'username': self.username(),
                'university': self.university(),
                'major': self.major(),
                'address': self.address(),
                'skills': self.skills(),
                'birthday': self.birthday(),
                'introduction': self.introduction() || ''
            }, function (data) {
                if (data.success) {
                    var new_user = data.user;
                    self.username(new_user.username);
                    self.university(new_user.university);
                    self.major(new_user.major);
                    self.address(new_user.address);
                    self.skills(new_user.skills);
                    self.birthday(new_user.birthday);
                    self.introduction(new_user.introduction);
                    alert('update success');
                }
                else {
                    alert("failed")
                }
            })
        }
    }

    ko.applyBindings(new UserSettingsBasicViewModel());

    $('.settings-left li').click(function (e) {
        $('.settings-left li').removeClass('active');
        this.classList.add('active');
    });

});
