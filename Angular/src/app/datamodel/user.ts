export class User {

    name : string;

    password : string;

    isAdmin : boolean = false;

    token? : string = "";

    constructor(name : string, password : string) {
        this.name = name;
        this.password = password;
    }
    
}