package lansedeniao.presentation.printer;

import lansedeniao.presentation.model.ProfileModel;

public class ProfilePrinter {

    public void print(ProfileModel profileModel) {
        System.out.println("==========");
        System.out.println("Name" + profileModel.getUsername());
        System.out.println("=========");
    }
}
