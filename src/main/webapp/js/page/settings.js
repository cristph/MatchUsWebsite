$(function () {
    "use strict";
    function User() {
        this.username = ko.observable();
        this.university = ko.observable();
        this.major = ko.observable();
        this.address = ko.observable();
        this.skills = ko.observableArray([]);
        this.birthday = ko.observable();
        this.introduction = ko.observable();
    }

    function UserSettingsViewModel() {
        var self = this;
        self.user = ko.observable(new User());
        self.active_part = ko.observable(1);

        $.get("/user/settings/basic", null, function (data) {
            var new_user = data;
            self.user().username(new_user.username);
            self.user().university(new_user.university);
            self.user().major(new_user.major);
            self.user().address(new_user.address);
            self.user().skills(new_user.skills);
            self.user().birthday(new_user.birthday);
            self.user().introduction(new_user.introduction);
        })
        self.update = function () {
            $.post("/user/settings/basic", {
                'username': self.user().username(),
                'university': self.user().university(),
                'major': self.user().major(),
                'address': self.user().address(),
                'skills': self.user().skills(),
                'birthday': self.user().birthday(),
                'introduction': self.user().introduction() || ''
            }, function (data) {
                if (data.success) {
                    var new_user = data.user;
                    self.user().username(new_user.username);
                    self.user().university(new_user.university);
                    self.user().major(new_user.major);
                    self.user().address(new_user.address);
                    self.user().skills(new_user.skills);
                    self.user().birthday(new_user.birthday);
                    self.user().introduction(new_user.introduction);
                    alert('update success');
                }
                else {
                    alert("failed")
                }
            })
        }
    }

    ko.applyBindings(new UserSettingsViewModel());
});
