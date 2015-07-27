function User() {
    this.username = ko.observable();
    this.sex = ko.observable();
    this.university = ko.observable();
    this.major = ko.observable();
    this.address = ko.observable();
    this.birthday = ko.observable();
    this.mobilephone = ko.observable();
    this.telephone = ko.observable();
    this.qq = ko.observable();
    this.instruction = ko.observable();
}

function UserSettingsViewModel() {
    var self = this;
    self.user = ko.observable(new User());
    self.active_part = ko.observable(1);

    $.getJSON("/user/settings/basic", function (data) {
        var new_user = data;
        self.user().username(new_user.username);
        self.user().sex(new_user.sex);
        self.user().university(new_user.university);
        self.user().major(new_user.major);
        self.user().address(new_user.address);
        self.user().birthday(new_user.birthday);
        self.user().mobilephone(new_user.mobilephone);
        self.user().telephone(new_user.telephone);
        self.user().qq(new_user.qq);
        self.user().instruction(new_user.instruction);
    });
    self.update = function () {
        $.post("/user/settings/basic", {
            'username': self.user().username(),
            'sex': self.user().sex(),
            'university': self.user().university(),
            'major': self.user().major(),
            'address': self.user().address(),
            'birthday': self.user().birthday(),
            'mobilephone': self.user().mobilephone(),
            'telephone': self.user().telephone(),
            'qq': self.user().qq(),
            'instruction': self.user().instruction() || ''
        }, function (data) {
            if (data.success) {
                var new_user = data.user;
                self.user().username(new_user.username);
                self.user().sex(new_user.sex);
                self.user().university(new_user.university);
                self.user().major(new_user.major);
                self.user().address(new_user.address);
                self.user().birthday(new_user.birthday);
                self.user().mobilephone(new_user.mobilephone);
                self.user().telephone(new_user.telephone);
                self.user().qq(new_user.qq);
                self.user().instruction(new_user.instruction);
                alert('update success');
            }
            else {
                alert("failed")
            }
        })
    }
}

$(function () {
    "use strict";
    ko.applyBindings(new UserSettingsViewModel(), document.getElementById('ko-content'));
    $('.avator-img > img').change(function() {
        alert(this);
    });
});
