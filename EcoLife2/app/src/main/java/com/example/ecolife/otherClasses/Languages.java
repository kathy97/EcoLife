package com.example.ecolife.otherClasses;

import java.util.HashMap;

public class Languages
{

    public enum Lang {
        GERMAN, ENGLISH
    }

    private static Lang currentLanguage;

    private static HashMap<String, String> german = new HashMap<>();
    private static HashMap<String, String> english = new HashMap<>();

    public static void setCurrentLanguage(Lang language) {
        currentLanguage = language;
    }

    public static void setLanguages() {
        setEnglish();
        setGerman();
    }

    private static void setEnglish()
    {
        //region Dropdown vor Login
        english.put("imprint","Imprint");
        english.put("website","Website");
        english.put("languages","Languages");
        //endregion

        //region Dropdown nach Login
        english.put("home","Home");
        english.put("calendar","Calendar");
        english.put("habits","Habits");
        english.put("myHabits","My habits");
        english.put("account","Account");
        english.put("logout", "Log out");
        //endregion

        //region Alert dialog messages
            //region Habits
             english.put("addHabitSucceed","We successfully added this habit to your habits!");
             english.put("addHabitFailed","Sadly, we could not add this habit to your habits right now!");
             english.put("habitExists","You already joined this habit!");
            //endregion

            //region Menu Website
            english.put("note","This page is still in progress!");
            //endregion

            //region AccountEdit
             english.put("usernameExists","This username already exists!");
             english.put("usernameChanged","Your username is successfully changed!");
             english.put("error","We were not able to change your username!");
             english.put("dontEqual","Please check your new username and the repetition to be sure they are equal.");
            //endregion

            //region Change passcode
              english.put("wrongRep","You may have repeated your new password wrong!");
              english.put("changeSucceed", "Your password is changed successfully!");
              english.put("changeFailed", "We weren´t able to change your password, please check your input again!");
              english.put("changePwMessage","You may have entered a wrong old password!");
            //endregion

            //region Delete Account
            english.put("accDeleted","Your account is successfully deleted!");
            english.put("accDelFailed","There was an error deleting your account!");
            //endregion

            //region SingleDateActivity
            english.put("noDoneHabits","You did not follow any habits this day!");
            //endregion

            //region SignUpActivity
            english.put("mailExists","This mail address already exists!");
            english.put("signUpFailed","Signing up sadly failed... \n\nPlease retry later!");
            english.put("sShowCorrectYear","Please click on the small number in the left top corner to choose the correct year!");
            english.put("invalidAge","You have to be at least 13 years old to sign in!");
            english.put("wrongPasscodeRep","You may have repeated your password wrong!");
            english.put("missingInput","You have to fill in everything!");
            english.put("signUpSucceed","You will soon receive a mail with a random code to verify your account!");
            //endregion

            //region LogInActivity
            english.put("wrongLoginData","Your login data might be wrong!");
            //endregion

            //region ResetPasscodeChangeActivity
            english.put("pwChanged","Your password is changed successfully!");
            english.put("pwWrongRepeated","Password and repetition is not equal! \nPlease check your input!");
            english.put("codeWrong","You may have entered a wrong code!");
            english.put("pwFailed","We were not able to change your password! \nPlease check if you got an internet connection and retry!");
            //endregion

            //region Verify
            english.put("verifyFailed","Sadly it was not possible to verify your account... \nPlease check your internet connection and retry later!");
            english.put("verifyCodeWrong","Please check if you have written your verification code correctly!");
             //endregion

            //region Habits
             english.put("noHabitsTitle","Add habits!");
             english.put("noHabitsContent","For habits to display here, you need to go to Habits and add some!" +
                     "\n\nAfter you have added some habits and you have done some during the day, you can check them!");
             //endregion
        //endregion

        //region Mail texts
             //region mail for account verification
              english.put("subjectAccVerify","Account verification");
              english.put("AccVerifyMsgPart1","Dear user, \n\nin this mail you receive your verification code. \nYour verify code is: ");
              english.put("AccVerifyMsgPart2", "\n\nWith best regards, \nyour Eco-Life Team!");
             //endregion

             //region mail for  username request
              english.put("subjectUsernameRequest","Username request");
              english.put("usernameRequestMsgPart1","Dear user, \n\nin this mail you receive your username, " +
                "so you can log in again. \nYour username is: \n\n");
              english.put("usernameRequestMsgPart2","\n\nWith best regards, \nyour Eco-Life Team!");
              //endregion

             //region mail for password reset
             english.put("subjectResetPw","Password reset!");
             english.put("resetPwContent1","Dear user, \n\nin this mail you receive a random code to reset your password." +
                "\nSince safety comes first, we are not able to mail you your real password. \nYour code is: \n");
             english.put("resetPwContent2","\n\nWith best regards, \nyour Eco-Life Team!");
            //endregion
        //endregion

        //region Progress Message
        english.put("pleaseWaitProgressTitle","Please wait...");
        english.put("pleaseWaitProgressMessage","Your data is currently loading!");
        //endregion

        //region Log in
        english.put("login", "LogIn");
        english.put("username", "Username");
        english.put("password", "Password");
        english.put("forgotUsername", "Forgot username?");
        english.put("forgotPassword", "Forgot password?");
        english.put("noAccount", "No Account yet?");
        english.put("loginButton", "Login");
        //endregion

        //region Get Username
        english.put("getUsernameLabel","Forgot username?");
        english.put("getUsernameDescription","For requesting your username, please enter your \ne-mail address! \n\nYou will receive your username per mail. \n\nHINT: This may take a moment!");
        english.put("usernameRequest","Request");
        //endregion

        //region Sign in
        english.put("signinTitle","SignUp");
        english.put("name","Name");
        english.put("familyname","Last name");
        english.put("birthday","Birthday");
        english.put("passwordRep","Repeat password");
        english.put("signinButton","Sign-in");
        english.put("signinDisclaimer","Fill out every field!");
        english.put("datepick","Choose");
        english.put("gender","Gender");
        //endregion

        //region Reset Password
        english.put("resetPasswordLabel","Forgot password?");
        english.put("resetPasswordDescription","Please enter your \ne-mail address to reset your password! \n\nYou will receive a random code per mail. \n\n\nHINT: This may take a moment!");
        english.put("resetPasswordRequest","Request");
        //endregion

        //region  Reset password change
        english.put("resPwChangeTitle","Change password");
        english.put("resPwNewPw","New password");
        english.put("resPwNewPwRep","Repeat password");
        english.put("resPwConfirm","Confirm");
        //endregion

        //region Account verify
        english.put("accVerifyTitle","Account verification");
        english.put("accVerifyDescription","To verify your account, you have to enter the code you received in an mail. \n\nIf you did not receive a code, you may have entered a not valid e-mail address." +
                "\n\nIf you entered the right mail-address, please click on the resend button!");
        english.put("accVerifyConfirm","Confirm");
        //endregion

        //region Imprint
        english.put("imprintTitle","Imprint");
        english.put("personalData","Developer information");
        english.put("aboutApp","About the app");
        english.put("myData","Katharina Schury \nAustria");
        english.put("copyRight","Copyright");
        english.put("crContent","App owned by: \nbfi IT-L@B Kärnten \n\nCopyright: \nMost icons and images are from icons8. \nThe only one image, not from icons8 is the logo, which is designed by myself." +
                "\n\nLink:\nhttps://icons8.de/icons" +
                "\nUsing the app is in the responsibility of the user himself. \nPersonal data will not be collected!");
        //endregion

        //region Calendar
        english.put("calendarTitle","Calendar-Overview");
        //endregion

        //region Language
        english.put("languageTitle", "Language selection");
        //endregion

        //region Short descriptions
        english.put("DescButton","Description");
        english.put("JoinButton","Join");

        english.put("sepWTitle","Separate waste");
        english.put("sepWDesc","Where belongs that? \nWhat belongs into plastic waste? \nQuestions you may ask yourself every day ...");

        english.put("recTitle","Recycling");
        english.put("recDesc","Recycling is about to exploit old items. \n\nGo ahead and check out our tips for recycling!");

        english.put("upcTitle","Upcycling");
        english.put("upcDesc","From old to new! \n\nCrafting new items is easy and can be much fun too.");

        english.put("redPlTitle","Reduce plastic");
        english.put("redPlDesc","The conglomeration of plastic grows ... \n\nBesides, plastic cannot compost. To help our planet we should reduce plastic.");

        english.put("nutrTitle","Nutrition");
        english.put("nutrDesc","Nutrition is essential. \n\nWithout food we would not be viable.");

        english.put("veggieTitle","Vegetarian");
        english.put("veggieDesc","Everything in life has advantages and disadvantages, as well as meat ...\n\nThere are some reasons why less meat can be a good decision!");

        english.put("veganTitle","Vegan");
        english.put("veganDesc","Vegan nutrition is obviously the most disagreed topic ... \n\nEspecially if it is really that eco-friendly or healthy!");

        english.put("reuseInfoTitle","Reuse information");
        english.put("reuseInfoDesc","Have you ever asked yourself why to switch to reusable alternatives? \nLets read and find out!");

        english.put("reuseBagTitle","Reusable bags");
        english.put("reuseBagDesc","There are more and more reusable bags out there. \n\nThose are a way better option to not compostable plastic bags!");

        english.put("reuseCupTitle","Reusable cups");
        english.put("reuseCupDesc","Less waste, refillable and always by your side! \n\nThose are just three advantages of reusable cups.");

        english.put("reuseBottleTitle","Reusable bottles");
        english.put("reuseBottleDesc","Imagine you are out with your friends, you are thirsty - isn´t it good to have a refillable and reusable water-bottle with you?");

        english.put("resTitle","Spare resources");
        english.put("resDesc","Primary materials aren´t always renewable ... \n\nWe better should take care of resources to spare our planet.");

        english.put("swTitle","Save water");
        english.put("swDesc","For us, water is self-evident. \n\nA majority of poor countries don´t even have clear, drinkable water ...");

        english.put("spTitle","Save power");
        english.put("spDesc","We mostly consume electricity from environment damaging sources. \nDespite the less harmful sources of power, we use much more than we need!");

        english.put("cfTitle","Car-Free");
        english.put("cfDesc","How often do we really need our car? \nIs it really necessary to use it on short distances? \n\nWhy don´t ride your bike in summer and do something great for your health and the earth!");

        english.put("conTitle","Consumption behavior");
        english.put("conDesc","We tend to spend our money on stuff we don´t even need. \nThis leads to overproducing goods to sell. \n\nSave money and avoid overproducing goods!");

        english.put("zwTitle","Zero-Waste");
        english.put("zwDesc","Want a challenge? \n\nTry to reduce your waste as  much as possible and try out the `Zero-Waste` trend.");

        english.put("noStrTitle","No straws");
        english.put("noStrDesc","Do we really need straws? \n\nNo! \n\nStill, a drink with a straw does look fancy.");

        english.put("rsTitle","Local and Seasonal");
        english.put("rsDesc","No matter where you live, nature offers you a great variety of foods. \n\nBuy local and you will not regret it!");

        english.put("habitsTitle","Habits");
        //endregion

        //region Home
        english.put("homeChangeCV","Change calendar-view");
        english.put("homeMyHabits","My habits");

        english.put("monday","Monday");
        english.put("tuesday","Tuesday");
        english.put("wednesday","Wednesday");
        english.put("thursday","Thursday");
        english.put("friday","Friday");
        english.put("saturday","Saturday");
        english.put("sunday","Sunday");

        english.put("january","January");
        english.put("february","February");
        english.put("march","March");
        english.put("april","April");
        english.put("may","May");
        english.put("june","June");
        english.put("july","July");
        english.put("august","August");
        english.put("september","September");
        english.put("october","October");
        english.put("november","November");
        english.put("december","December");
        //endregion

        //region AccountInfo
        english.put("usernameLabel","Username:");
        english.put("nameLabel","Name:");
        english.put("familynameLabel","Last name:");
        english.put("genderLabel","Gender:");
        english.put("birthdayLabel","Birthday:");
        english.put("AccEditButton","Change username");
        english.put("AccDeleteButton","Delete account");
        english.put("ChangePwButton","Change password");
        //endregion

        //region Account Edit
        english.put("confirm","Confirm");
        english.put("oldUsername","Old username");
        english.put("newUsername","New username");
        english.put("repeatUsername","Repeat");
        english.put("AccEditTitle","Change username");
        //endregion

        //region Change password
        english.put("changePwTitle","Change password");
        english.put("oldPassword","Old password");
        english.put("newPassword","New password");
        english.put("changePwRep","Repetition");
        //endregion

        //region Delete Account
        english.put("deleteAccTitle","Delete account");
        english.put("deleteAccAlert","It is a pity that you decided to leave `Eco-Life`! "+
                "\n\nWhen deleting your account, your whole personal data gets lost, why we cannot restore your account in the future ..."+
                "\n\nHint: \nIf you would like to rejoin later, we ask you to create a new account then!");
        english.put("deleteButton","Delete");
        //endregion

        //region For all habits needed
        english.put("BackToHabits","Back to habits");
        english.put("JoinHabit","Join");
        //endregion

        //region Separate Waste
        english.put("sepWasteTitle","Separate waste");
        english.put("sepWasteContent1","Separating waste can be a lot of work, but it comes with many advantages!"+
                "\nIf you separate waste correctly, it can be recycled more easily and reprocessed."+
                "\n\nSince a huge part of humanity is really careless, large quantities of trash including plastic are dumped into the ocean ... "+
                "\n\nThe conglomeration of waste is twice as big as France!"+
                "\nFor your better understanding, that is apr. 1287,902 squarekilometers."+
                "\n\nMy advice:"+
                " \nTo everyone who wants to start separating waste, please inform yourself how to do it correctly where you life. Sadly it is not consistent everywhere ..."+
                "\nI´ve provided you some information how it is done where i live!");
        english.put("wasteSeparation","To different wastes");


        english.put("plastic","Plastic");
        english.put("residual","Residual waste");
        english.put("paper","Paper");
        english.put("glass","Glass");
        english.put("eco","Eco waste");
        english.put("other","Other waste");
        english.put("sepWasteHint","Plastic waste contains the description of metal waste!");

        english.put("plasticTitle","Plastic");
        english.put("headlineBottles","Plastic-bottles for:");
        english.put("contentBottles","Drinks (PET) \nDetergent or Cleansers \n-Fabric softener, household detergent, glass cleanser \n Grocery bottles \n-Vinegar, oil, milk...\n" +
                "\nDistilled water, refrigerant, others... \n-NO motor oil" +
                "\nBody care products");
        english.put("headlineTins","Tins, small metals:");
        english.put("contentTins","Beverage can \nTins \n-Grocery, pet food \nMenu bowls out of metal "+
                "\n-Prepared dishes, pet food \nOther metal packaging: \n-Closures, lids, tubes, silver foil "+
                "\nSmall metals \n-Radius smaller than 20 cm, not sharp/pointed "+
                "\n-No batteries/wires");
        english.put("headlinePacks","Beverage boxes:");
        english.put("contentPacks","Milk, juice \nWine");

        english.put("residualTitle","Residual waste");
        english.put("generallyIn","In general:");
        english.put("residualContent","Products which cannot be disposed in another way. "+
                "\n\nThey have to be free from any dangerous or poisonous ingredients. "+
                "\n\nResidual waste also is not allowed to be bulky.");

        english.put("paperTitle","Paper");
        english.put("paperContent","Newspapers, illustrated magazines, catalogues, prospects"+
                "\n\nWriting paper, envelopes (with and without windows)"+
                "\n\nNotebooks, telephone books"+
                "\n\nUncoated cartons"+
                "\n\nCorrugated board" +
                "\n\nPaper bags, cardboard boxes, boxes – please fill them with paper or unfold them!");
        english.put("paperHint","Hint");
        english.put("paperHintContent","Only because something might seem to be obvious, it does not mean that it really is..." +
                "\nFor example large cardboard boxes belong to the collecting point for refuse!");


        english.put("glassTitle","Glass");
        english.put("whiteglassTitle","White or uncolored glass");
        english.put("whiteglasssContent","Uncolored bottles, uncolored canned-glasses" +
                "\n\nUncolored milk and soft drink bottles" +
                "\n\nUncolored wine or liquor bottles" +
                "\n\nUncolored glass vials");
        english.put("coloredglassTitle","Colored or green glass");
        english.put("coloredglassContent","Colored bottles, colored canned-glasses" +
                "\n\nColored wine, liquor or soft drink bottles " +
                "\n\nColored glass vials" +
                "\n\nLightly tinted glass");

        english.put("ecoTitle","Eco waste");
        english.put("ecoContent","Garden:\n" +
                "\nLawn cuttings, leaves, tree and shrub cuttings, harvesting residues, shrubs, windfalls, water plants.\n" +
                "\n\nKitchen/house:\n" +
                "\nUncooked and unseasoned fruit and vegetable waste, plants with less flower soil at the root area, old residues of bread, tea and coffee grounds.\n" +
                "\n\nOnly those wastes, you would also put into the composting!\n" +
                "\n\nChristmas trees (up to 1,5m)");
        english.put("ecoHint","Hint");
        english.put("ecoHintContent","Not everything that seems to be logic belongs in!\n" +
                "\n\nMeat, bones, dairy goods, leftovers etc. belongs into residual waste. Such as roots, lots of green waste...\n" +
                "\n\nIf you are insecure, please make a research about how to correctly dispose this kind of waste in your living area!");

        english.put("otherTitle","Other waste");
        english.put("otherContent","\"Old clothes belong in the charity collection bin or center, as an alternative you can donate old clothing to care centers." +
                "\n\nOld and expired meds should better be returned to the pharmacy because they dispose them correctly.\n" +
                "\n\nBatteries, electronic devices etc. belong to the hazardous waste collecting center!\n" +
                "\n\nReusable plastic bottles, beverage crates and plastic pallets can be returned at the shop.\n" +
                "\n\n\nNaturally here it is the same story, if you are insecure about what to do, please search the right solution online.\n" +
                "\n\nIn Germany for example there is a pawn on plastic bottles, in Austria there is none...\n" +
                "So you can bring empty bottles back to the store in Germany, but not in Austria!\n");
        //endregion

        //region Recycle
        english.put("recycleTitle","Recycle");
        english.put("recHeadlineText","Buy reusable bottles instead of non-returnable bottles!");
        english.put("recFirstPoint","Repair goods instead of throwing them away!");
        english.put("recFirstUnderpoint","Save money, reduce waste.");
        english.put("recSecondPoint","Buy long-lasting products!");
        english.put("recThirdPoint","Rent and use instead of own!");
        english.put("recThirdUnderpoint","Tools/goods you would only need once. \n\nBooks/movies - for example library`s and video library´s. \n\nWorks with costumes or sport tools as well.");
        english.put("recFourthPoint","Flea market or swap meet!");
        english.put("recFourthUnderpoint","Chance of getting certain things, such as books, games, toys or decoration cheaper... \n\nEarning money with old, well preserved goods" +
                "                    \n\nIf you do not want or need it any longer, does not mean nobody could want it! You also reduce waste.");
        english.put("recFifthPoint","Rechargeable batteries over batteries!");
        english.put("recFifthUnderpoint","Long-lasting and more friendly to the environment.");
        english.put("lastPoints","Lunchbox instead of plastic bags!" +
                "\n\nAvoid unnecessary packaging!" +
                "\n\nUse reusable alternatives!" +
                " \n\nDo I really need that?");
        //endregion

        //region Upcycle
        english.put("upcylceTitle","Upcycle");
        english.put("upcycleContent","It is super easy, to make new things out of old ones!" +
                "\n\nWho does not know that? " +
                "\nYou have got a lot of old stuff lying around at home, nobody wants or need anymore ..." +
                "\n\nThe wardrobe is stuffed with clothes, but nothing to wear? ?" +
                "\nA good reason could be that we hoard clothing we do not wear anymore - obviously we will not give them away too..." +
                "\n\nThat is where 'Upcycling' takes place!" +
                "\nYou do not only utilize old goods, you create something new and individual as well - something no one else owns, in that special way!" +
                "\n\n\nDown there are three different links to DIY-Upcycling pages!");
        english.put("firstLink","OneCrazyHouse");
        english.put("secondLink","Home-Hacks");
        english.put("thirdLink","Life-Hack");
        //endregion

        //region Reduce Plastic
        english.put("redPlasticTitle","Reduce plastic");
        english.put("redPlasticWhy","Why?");
        english.put("redPlasticWhyContent","Plastic cannot be composted. Since humanity is really careless, the plastic-waste is getting into the ocean`s and sea`s...\n" +
                "\n\nFish and other marine organisms get caught in there and die agonizing...\n" +
                "\nOften, marine organisms get washed to land, which get them to dry out in the sun.\n" +
                "\n\nPlastic does not only concern marine organisms and fish, it also concerns land animals!\n" +
                "\nUnknowingly they consume those plastics, that way they get plastic into their organism...\n" +
                "\n\nDid you know that humans also do have plastic in their blood circulation?");
        english.put("redPlasticWhat","What can I do by myself?");
        english.put("partOne","Avoid unnecessary disposable products!" +
                "\n\nGo to unpacked stores!" +
                "\n\nReusable instead of disposable!" +
                "\n\nBuy loose fruits and vegetables!" +
                "\n\nBring along your own reusable cups or boxes!");
        english.put("partTwo","If you take a coffee to go or takeaway food.");
        english.put("partThree","Watch out for certain ingredients!");
        english.put("partFour","Acryclate Copolymer(AC); Polyamide(PA); Siloxane" +
                "\nPolyethylen(PE); Polypropylen(PP); Polyethylenterephtalat(PET)" +
                "\n - These are micro plastics");
        english.put("partFive","Solid shampoo, soap & conditioner!");
        english.put("partSix","They have less and in some case no packaging.");
        english.put("partSeven","Natural materials instead of synthetics in clothing!\n" +
                "\n\nCollect waste and separate it!");
        english.put("redPlasticLink","My Plastic Free Life");
        //endregion

        //region Nutrition
        english.put("nutritionTitle","Nutrition");
        english.put("nutrIG","In general");
        english.put("nutrIGContent","Food is important, we could not life without." +
                "\nOur body needs energy for all daily activities, work, and simple body functions. We get this energy from food and sleep." +
                "\n\nFood contains a lot of precious and healthy ingredients." +
                "\nThose again strengthen our immune system and prevent illnesses." +
                "\n\nWith the right lifestyle and a healthy nutrition you also prevent so called widespread diseases.");
        english.put("nutrTipps","Tips");
        english.put("nutrOne","Freshly cooked meals instead of precooked and prepared meals!" +
                "\n\nGrow fruits and vegetables of possible on your own!" +
                "\n\nGrow spices and herbs in flower pots in or around your home!" +
                "\n\nBuy local and seasonal!");
        english.put("nutrTwo","Take care of sigill´s" +
                "\n\nResearch what is currently growing");
        english.put("nutrThree","Reduce meat!");
        english.put("nutrFour","Take care of sigill´s" +
                "\n\nPrefer local farmers" +
                "\n\nWatch out for species-appropriate animal farming, avoid factory farming");
        english.put("nutrFive","Watch out for open air sigill´s!");
        english.put("nutrSix","Eggs" +
                "\n\nMilk - from cows, who can breathe fresh air and eat fresh grass outside.");
        english.put("nutrSeven","Take care of route of transportation!" +
                "\n\nGo to local organic or weekly markets!" +
                "\n\nLocal and seasonal nutrition!");
        //endregion

        //region Vegetarian
        english.put("vegTitle","Vegetarian");
        english.put("vegIg","In general");
        english.put("vegIgContent","For the breeding of meat, they clear jungles and (rain-) forests, which produce very important oxygen." +
                "\nThe CO² emission per each kilogram meat is Apr. 36kg, besides you need therefore 10 kilograms wheat... " +
                "\n\nThe majority of the consummated meat comes from factory farming, however if you try anxious to get meat from species-appropriate animal farming, it’s healthier in general." +
                "\nThe fats - especially the saturated fatty acids, meat contains make the bad cholesterol rise faster." +
                "\n\nMeat, especially pork, mostly contains antibiotics as well, which could make us resistant to certain antibiotics if we would need them...");
        english.put("vegAdv", "What are the advantages of meat?");
        english.put("vegOne","Valuable protein!");
        english.put("vegTwo","Which we need to produce energy and for a lot body functions.");
        english.put("vegThree","Necessary vitamins A and B!");
        english.put("vegFour","A lack of these vitamins can lead to: " +
                "\nMyatrophy/muscle wastage \nCardiac degeneration " +
                "\nInsomnia/sleep disturbances \nLoss of appetite \nAnemia");
        english.put("vegFive","Provided with minerals and iron!");
        english.put("vegSix","Without iron we are weak, tired, and powerless and our immune-system is weakened..." +
                "\n\nAlways was a part of nutrition!");
        english.put("vegSeven","Source of life for a lot of farmers!");
        //endregion

        //region Vegan
        english.put("vegan_Title","Vegan");
        english.put("veganIg","In general");
        english.put("veganIgContent","To provide some information's about veganism, I tried to inform myself online." +
                "\n\nA huge topic was the disagreement between people, but also the nonsense you can find online..." +
                "\n\nIf you read the articles carefully and understand the content, you will soon notice!" +
                "\n\nOther mentioned reasons where the environment, or the own health..." +
                "\n\nAlthough, that is all a contradiction with itself!" +
                "Animal products do have some essential content, such as plant products!");
        english.put("veganWhy","Reasons why vegan could be okay too!");
        english.put("veganOne","If you are allergic to animal proteins!");
        english.put("veganTwo","There are really people who are allergic to animal proteins that are why they cannot eat them.");
        english.put("veganThree","Ethical reasons!");
        english.put("veganFour","No matter if it is the love to animals, in way that nearly goes outside the envelope, the murder of farm animals or the so called utilization!");
        english.put("veganFive","Resignation of antibiotic-carrying products!");
        english.put("veganSix","As an alternative you could take care of the origin..." +
                "\n\nThere is no doubt that some animal products are stuffed with antibiotics, but that is still no reason to think everything else is stuffed with antibiotics too!");
        english.put("veganVeryImp","!!!VERY IMPORTANT!!!");
        english.put("veganVeryImpContent","Talk to your doctor about your plans of eating plant based, regularly check your blood and be okay taking supplements and vitamins!");
        english.put("veganLinks","Interesting websites");
        english.put("veganLinksContent","If you want to know more about veganism, I have added some links!");
        english.put("veganLink1","Higher stroke risk?");
        english.put("veganLink2","How it affects your body");
        english.put("veganLink3","Vegan without hurting health");
        english.put("veganLink4","10 Reasons");
        english.put("veganLink5","Why vegan?");
        //endregion

        //region Reuse Info
        english.put("reuseInfTitle","Information about 'Reuse'");
        english.put("reuseInfWhy","Why?");
        english.put("reuseInfWhyContent","A great way to reduce mountains of trash is to use reusable items. It is also a good way to spare resources since they don’t need to produce lots of new products." +
                "\n\nAlternatives to single-use items life longer, which is a reason to say they are cheaper over time.");
        english.put("reuseInfAlt","Why alternatives are better!");
        english.put("reuseInf1","Washable!");
        english.put("reuseInf2","It depends on what alternative you use." +
                "\n\nAccording to that, they can be dishwasher-safe or washer-safe!");
        english.put("reuseInf3","Longer lifespan!");
        english.put("reuseInf4","Opposite to disposable plastic products you can use them over years!" +
                "\n\nSince there is a higher durability, alternatives can be used over and over again, they do not wear off as fast as disposable products.");
        english.put("reuseInf5","More friendly to the environment!");
        english.put("reuseInf6","You throw away less, and it does not need to be reproduce as much.");
        english.put("reuseInf7","Cheaper!");
        english.put("reuseInf8","In the first purchase, it might be more expensive, but if you take a minute to rethink and calculate, alternatives are over the time way cheaper.");
        english.put("reuseInfWhySwitch","We should change to alternatives because ...");
        english.put("reuseInfRes1","Conglomeration if waste is twice as big as France!");
        english.put("reuseInfRes2","The area of France 643,801 km², if you calculate the double of that, you will get 1287,602 km²...");
        english.put("reuseInfRes3","Hardly and difficult to compose!" +
                "\n\nCannot be recycled!");
        //endregion

        //region Reuse Bag
        english.put("rBagTitle","Reuse your bag");
        english.put("rBagIntr","Introduction");
        english.put("rBagIntrContent","You get plastic bags almost everywhere and really cheap. If you buy fruits and vegetables you can put them in plastic bags for free." +
                "\n\nTheoretically you can reuse plastic bags too. Side effect is, that they are not as stable as alternatives, such as not as long living as them...");
        english.put("rBagAlt","What are the alternatives?");
        english.put("rBagAltContent","Burlap/jute" +
                "\n\nFabrics" +
                "\n\nLinen" +
                "\n\nCotton" +
                "\n\nReusable polypropylene bags" +
                "\n\nMeshes-bags" +
                "\n\nLitter-bags");
        //endregion

        //region Reuse Cup
        english.put("rCupTitle","Reuse your cup");
        english.put("rCupIntr","Introduction");
        english.put("rCupIntrContent","Because of the amount of offered possibilities, it is getting easier and easier to switch to reusable alternatives." +
                "\n\nIf you take a coffee to go or another hot drink, it is common to get a plastic coated paper cup with a plastic lid..." +
                "\n\nIf you grab a cold drink, it normally is in a transparent plastic cup!");
        english.put("rCupAlt","What are the alternatives?");
        english.put("rCupAltContent","Thermal mug made out of glass or aluminum" +
                "\n\nAcrylic-resin/hard plastic" +
                "\n\nPottery" +
                "\n\nBamboo" +
                "\n\nGlass" +
                "\n\nSteel" +
                "\n\nSilicon");
        english.put("rCupAltContent2","Normally saves a lot of storage because they mostly are foldable.");
        //endregion

        //region Reuse Bottle
        english.put("rBottleTitle","Reuse your bottle");
        english.put("rBottleIntr","Introduction");
        english.put("rBottleIntrContent","Lots of materials are crucial long living and better to clean than PET-bottles you buy at a supermarket! Clearly they are not made you reuse over and over again..." +
                "\n\nSince plastic or PET- bottles are very light, they are quite perfect to sell drinks in." +
                "\n\nAnother story is the price!" +
                "\n\nIf you compare smoothies sold in glass-bottles to those, they sell in plastic-bottles, they are more expensive.");
        english.put("rBottleAlt","What are the alternatives?");
        english.put("rBottleAltContent","Thermal bottles out of glass or aluminum" +
                "\n\nAcrylic-resin/hard plastic" +
                "\n\nSugarcane" +
                "\n\nBamboo" +
                "\n\nGlass" +
                "\n\nSteel");
        //endregion

        //region Spare resources
        english.put("srTitle","Spare resources");
        english.put("srWhat","What are resources?");
        english.put("srWhatContent","Resources are naturally occurring stand, for example woods, charcoal, water..." +
                "\n\nThey are spitted in renewable and non-renewable primary materials. For the environments sake we should take care of those primary materials and economize.");
        english.put("srTipps","Tips");
        english.put("srTipp1","Use the back of no longer needed papers as notepad!");
        english.put("srTipp1a","Why shouldn't we use the backside of no longer needed papers, if we have to write something down fast?");
        english.put("srTipp2","Print documents, Work sheets ... on both sides!");
        english.put("srTipp2a","You do not only save paper and some storage, you also save resources.");
        english.put("srTipp3","Turn of water while brushing teeth or shampooing hair!" +
                "\n\nOnly turn on the heat when it is cold!" +
                "\n\nWatch out for sigill´s!");
        english.put("srTipp3a","If products are recycled or environmental friendly produced.");
        english.put("srTipp4","Recycle and upcycle on your own!" +
                "\n\nStore foods right!" +
                "\n\nOnly buy what you really need!" +
                "\n\nCheck food after best before date!");
        english.put("srTipp4a","They have to write down a best before date, which is a law, even at products that can get spoiled...");
        english.put("srTipp5","Food sharing!");
        english.put("srTipp5a","Pass on foods to your friends, family or neighbors if you are not at home for a few days.");
        english.put("srTipp6","Second hand!");
        //endregion

        //region Zero Waste
        english.put("zeroWasteTitle","Zero-Waste");
        english.put("zwContent","Since the garbage collection is still growing, no matter how big it is right now, we need to start rethinking!" +
                "\n\nTo reduce waste is one thing, to life almost without waste another one!");
        english.put("zwHow","How to zero-waste?");
        english.put("zwHow1","At a certain part, our consumer behavior is also included in zero-waste. As a costumer we decide " +
                "what we buy, which products we put in our shopping cart and which not!");
        english.put("zwHow1a","Buy products in glass packaging/container. " +
                "\n\nAvoid unnecessary packaging.");
        english.put("zwAlternatives","Alternatives");
        english.put("zwOriginals","'Original'");

        english.put("zwAlt1","Safety razor");
        english.put("zwOrg1","Disposable razor");

        english.put("zwAlt2","Deodorant balm");
        english.put("zwOrg2","Deodorant spray");

        english.put("zwAlt3","Bamboo toothbrush");
        english.put("zwOrg3","Plastic toothbrush");

        english.put("zwAlt4","Real coffee");
        english.put("zwOrg4","Capsule coffee");

        english.put("zwAlt5","Reusable paper");
        english.put("zwOrg5","Silver foil");

        english.put("zwAlt6","Fabric bags");
        english.put("zwOrg6","Plastic bags");

        english.put("zwAlt7","Prepare salad on your own");
        english.put("zwOrg7","Pre-prepared salad");

        english.put("zwAlt8","Bring own cutlery");
        english.put("zwOrg8","Plastic cutlery");

        english.put("zwAlt9","Reusable bottles");
        english.put("zwOrg9","Plastic bottles");

        english.put("zwAlt10","Bring own food");
        english.put("zwOrg10","Snack bars");

        english.put("zwAlt11","Solid toothpaste/capsules");
        english.put("zwOrg11","Normal toothpaste \n");

        english.put("zwAlt12","Washable tissues");
        english.put("zwOrg12","Disposable tissues");

        english.put("zwAlt13","Package free natural soap \n");
        english.put("zwOrg13","Liquid soap, solid soaps with lots of packaging");

        english.put("zwAlt14","Shaving soap");
        english.put("zwOrg14","Shaving foam/gel");

        english.put("zwAlt15","Solid soap");
        english.put("zwOrg15","Shower gel");

        english.put("zwAlt16","Solid shampoo/conditioner bars");
        english.put("zwOrg16","Shampoo and conditioner");

        english.put("zwAlt17","Reusable cleansing pads");
        english.put("zwOrg17","Disposable cotton pads");

        english.put("zwAlt18","Laundry detergent powder");
        english.put("zwOrg18","Liquid laundry detergent");

        english.put("zwAlt19","Bamboo/steel earwax remover");
        english.put("zwOrg19","Earwax remover\n");

        english.put("zwAlt20","Peeling soap");
        english.put("zwOrg20","Peeling in a tub");

        english.put("zwAlt21","Brushes and combs made from natural materials");
        english.put("zwOrg21","Brushes and combs made from plastic ");

        english.put("zwAlt22","Reusable straws");
        english.put("zwOrg22","Plastic straws");

        english.put("zwAlt23","No ads stickers \n");
        english.put("zwOrg23","Against unwanted ads");

        english.put("zwAlt24","Returnable bottles");
        english.put("zwOrg24","Disposable bottles");

        english.put("zwAlt25","Menstrual cup");
        english.put("zwOrg25","Tampons");

        english.put("zwAlt26","Washable pads/sponges... \n");
        english.put("zwOrg26","Disposable feminine hygiene products");
        english.put("zwHacks","Zero-Waste Hacks");
        //endregion

        //region Save Power
        english.put("spTitel","Save power");
        english.put("spContent","In our days we need electricity for almost everything and daily. Without electricity we barely can cook or heat!" +
                "\n\nAnother way to spare the environment is to watch out where the electricity we use is from!");
        english.put("spEcological","Ecological");
        english.put("spNotEcological","Not ecological");
        english.put("spEco1","Wind energy");
        english.put("spEco2","Solar energy");
        english.put("spEco3","Hydro power");
        english.put("spNEco1","Nuclear power");
        english.put("spTipTitle","Tips");
        english.put("spTipContent","Turn off lights during the day!" +
                "\n\nTurn off unnecessary lights!" +
                "\n\nOnly turn on the heating if it’s cold!" +
                "\n\nLet your hair air dry in summer instead of bow drying!" +
                "\n\nOnly switch on the television, radio and computer if you really use it!" +
                "\n\nCharge your phone, tabled or iPod until the battery is full!" +
                "\n\nTake not needed devices off the power!" +
                "\n\nPitch chargers if you don’t need them!" +
                "\n\nIn summer or when the weather is great hang up the laundry outside instead of using the dryer!" +
                "\n\nRegularly defrost the refrigerator and the freezer!" +
                "\n\nDo not place the refrigerator next to heat sources!" +
                "\n\nUse residual heat from cooking plates or flatirons! " +
                "\n\nWait until the washer and dryer is full before you switch them on!" +
                "\n\nImmediately close the door from the refrigerator!");
        //endregion

        //region Save Water
        english.put("swTitel","Save water");
        english.put("swContent","Water is one of the most essential resources. " +
                "\n\nIn a lot of countries, especially poor ones, they do not even have clear water to drink.");
        english.put("swTips","Tips");
        english.put("swTipsContent","Switch off water while brushing teeth!" +
                "\n\nSwitch of water while shampooing hair!" +
                "\n\nTake short showers!" +
                "\n\nShowers over baths!" +
                "\n\nWait until you have got enough same clothes to do the laundry!" +
                "\n\nSwitch the dishwasher on if it is really full!" +
                "\n\nWash less cutlery and crockery per hand!" +
                "\n\nCollect rain water in rain barrels to water plants and garden!" +
                "\n\nWash fruits and vegetables in a bowl!");
        english.put("swLink","Water saving tips");
        //endregion

        //region Car-Free
        english.put("carFreeTitle","Car-Free");
        english.put("carFreeContent","All of us know that exhaust fumes are not good for the environment!" +
                "\n\nSince we don’t need a car all the time, it pays to avoid the car sometimes.");
        english.put("carFreeOptions","What possibilities are there?");
        english.put("carFreeOptionsContent","Walk short ways or ride your bicycle!" +
                "\n\nCarpools!" +
                "\n\nUse public transports!" +
                "\n\nUse the train on long destinations!" +
                "\n\nRide your bicycle more often!");
        //endregion

        //region Consumer-Behavior
        english.put("cbTitle","Consumer behavior");
        english.put("cbContent","Believe it or not, our behavior if it comes to consumption, also affects the environment!" +
                "\nTo harvest certain groceries, jungles and rainforests need to get cleared and the natured destroyed..." +
                "\n\nProducts are produced in abundance, and we throw them away in the end.");
        english.put("cbQuestions","Questions before buying!");
        english.put("cbQContent1","Do I need that?" +
                "\n\nWhat is at home?" +
                "\n\nCan I use it up?" +
                "\n\nWhat do I use it for?" +
                "\n\nIs it really necessary to import this?" +
                "\n\nAre there regional produced goods with the same use?");
        english.put("cbQContent2","Is there anything else with a shorter way of importation?");
        english.put("cbQContent3","What is necessary and what luxury?" +
                "\n\nDo I really need fresh bread short before the shop closes?");
        //endregion

        //region No straws
        english.put("noStrawsTitle","No straws");
        english.put("noStrawsContent","Since we do not need straws, we use them to decorate drinks and as something luxurious by time." +
                "\n\nIn rare cases, straws are not only useful, they are necessary as well!");
        english.put("noStrawsAlternatives","Alternatives");
        english.put("noStrawsAltContent","Bamboo" +
                "\n\nGlass" +
                "\n\nSteel" +
                "\n\nMacaroni" +
                "\n\nPaper");
        //endregion

        //region Local and Seasonal
        english.put("localSeasonalTitle","Local and Seasonal");
        english.put("localSeasonalContent","If you buy local and seasonal, you can easily avoid long ways of transportation and in glasshouses cultured fruits and vegetables." +
                "\n\nIt’s also easier to avoid pollutants in local and seasonal harvested foods. There are fewer chemicals needed to make the food be good on a longer term.");
        english.put("lsLink1","United Kingdom");
        english.put("lsLink2","Western/Northern Europe");
        english.put("lsLink3","United States");
        //endregion

        //region MyHabits
        english.put("myHabitsTitle","My habits");
        //endregion

        //region Push notification
        english.put("title","Have you done any habits today?");
        english.put("content","Don't forget to track your habits!");
        //endregion

        english.put("","");
        english.put("","");
    }

    private static void setGerman()
    {
        //region Dropdown vor Login
        german.put("imprint","Impressum");
        german.put("website","Website");
        german.put("languages","Sprachen");
        //endregion

        //region Dropdown nach Login
        german.put("home","Startseite");
        german.put("calendar","Kalender");
        german.put("habits","Gewohnheiten");
        german.put("myHabits","Meine Gewohnheiten");
        german.put("account","Account");
        german.put("logout", "Abmelden");
        //endregion

        //region Alert dialog messages
            //region Habits
            german.put("addHabitSucceed","Diese Gewohnheit wurde erfolgreich hinzugefügt!");
            german.put("addHabitFailed","Es ist leider ein Problem beim Hinzufügen der Gewohnheit aufgetreten!");
            german.put("habitExists","Du bist dieser Gewohnheit bereits beigetreten!");
            //endregion

            //region Menu Website
            german.put("note","Diese Seite ist derzeit leider noch in Bearbeitung!");
            //endregion

            //region AccountEdit
             german.put("usernameExists","Dieser Benutzername ist bereits vergeben!");
             german.put("usernameChanged","Dein Benutzename wurde erfolgreich geändert");
             german.put("error","Dein Benutzername konnte leider nicht geändert werden!");
             german.put("dontEqual","Bitte überprüfe ob dein neuer Benutzername mit der Wiederholung übereinstimmt.");
            //endregion

            //region Change passcode
            german.put("wrongRep","Dein neues Passwort wurde falsch wiederholt!");
            german.put("changeSucceed", "Dein Passwort wurde erfolgreich geändert!");
            german.put("changeFailed", "Leider konnte dein Passwort nicht geändert werden, bitte prüfe deine Eingaben!");
            german.put("changePwMessage","Du hast dein altes Passwort falsch eingegeben!");
             //endregion

            //region Delete Account
            german.put("accDeleted","Dein Account wurde erfolgreich gelöscht!");
            german.put("accDelFailed","Beim löschen deines Accounts ist ein Fehler aufgetreten!");
            //endregion

            //region SingleDateActivity
             german.put("noDoneHabits","Leider wurden an diesem Tag keine Gewohnheiten befolgt!");
            //endregion

            //region SignUpActivity
            german.put("mailExists","Diese eMail Adresse existiert bereits!");
            german.put("signUpFailed","Leider ist bei der Registrierung etwas schief gegangen. \n\nBitte versuche es später nocheinmal!");
            german.put("sShowCorrectYear","Um das korrekte Jahr auszuwählen, tippe auf die Zahl oben links in der Ecke!");
            german.put("invalidAge","Deine Alterseingabe ist ungültig, du musst mindestens 13 Jahre als sein um dich hier registrieren zu können!");
            german.put("wrongPasscodeRep","Du hast dein Passwort falsch wiederholt!");
            german.put("missingInput","Du musst alle Felder ausfüllen!");
            german.put("signUpSucceed","Du wirst in kürze einen Code zur Bestätigung deiner E-Mail Adresse per Mail zugeschickt bekommen!");
            //endregion

            //region LogInActivity
             german.put("wrongLoginData","Deine Anmeldedaten sind falsch!");
            //endregion

            //region ResetPasscodeChangeActivity
            german.put("pwChanged","Dein Passwort wurde erfolgreich geändert!");
            german.put("pwWrongRepeated","Das Passwort und die Wiederholung stimmen nicht überein! \nBitte überprüfe deine Eingaben.");
            german.put("codeWrong","Du hast einen falschen Code eingegeben!");
            german.put("pwFailed","Wir konnten dein Passwort leider nicht ändern! \nBitte überprüfe ob du eine verbindung zum Internet hast!");
            //endregion

            //region Verify
             german.put("verifyFailed","Leider konnten dein Account nicht bestätigt werden... \nBitte überprüfe deine Internetverbindung und versuche es später erneut!");
             german.put("verifyCodeWrong","Dieser Bestätigungs-Code scheint nicht zu existieren... \nBitte überprüfe deine Eingabe auf ihre Richtigkeit!");
            //endregion

            //region Habits
            german.put("noHabitsTitle","Füge Gewohnheiten hinzu!");
            german.put("noHabitsContent","Um hier Gewohnheiten angezeigt zu bekommen, musst du erst unter Gewohnheiten" +
                    ", welche hinzufügen! \n\nDann kannst du sie hier - wenn du sie befolgt hast - abhaken!");
            //endregion
        //endregion

        //region Mail texts
             //region mail for account verification
              german.put("subjectAccVerify","Account Verifikation");
              german.put("AccVerifyMsgPart1","Sehr geehrter Nutzer, \n\nmit dieser Mail erhaltest du deinen Bestätigungs-Code. \nDein Bestätigungs-Code lautet: ");
              german.put("AccVerifyMsgPart2", "\n\nMit freundlichen Grüßen, \ndein Eco-Life Team!");
             //endregion

             //region mail for  username request
             german.put("subjectUsernameRequest","Anforderung Benutzername");
             german.put("usernameRequestMsgPart1","Sehr geehrter Nutzer, \n\nmit dieser Nachricht erhaltest du deinen Benutzernamen " +
                "um dich wieder in der Eco-Life App einloggen zu können. \nDein Benutzername lautet: \n\n");
             german.put("usernameRequestMsgPart2","\n\nMit freundlichen Grüßen, \ndein Eco-Life Team!");
            //endregion

             //region mail for password reset
             german.put("subjectResetPw","Passwort zurücksetzung!");
             german.put("resetPwContent1","Sehr geehrter Nutzer, \n\nmit dieser Mail erhaltest du einen zufälligen Code, mit dem du dein Passwort zurücksetzen kannst." +
                     "\nAus Sicherheits-Gründen ist es uns leider nicht möglich, dir dein richtiges Passwort zuzusenden. \nDein Code lautet: \n");
             german.put("resetPwContent2","\n\nMit freundlichen Grüßen, \ndein Eco-Life Team!");
             //endregion
        //endregion

        //region Progress Message
        german.put("pleaseWaitProgressTitle","Bitte warten...");
        german.put("pleaseWaitProgressMessage","Daten werden geladen!");
        //endregion

        //region Log in
        german.put("login", "Anmeldung");
        german.put("username", "Benutzername");
        german.put("password", "Passwort");
        german.put("forgotUsername", "Benutzername vergessen?");
        german.put("forgotPassword", "Passwort vergessen?");
        german.put("noAccount", "Noch kein Account?");
        german.put("loginButton", "Anmelden");
        //endregion

        //region Get Username
        german.put("getUsernameLabel","Benutzername vergessen?");
        german.put("getUsernameDescription","Gib bitte deine E-Mail Adresse ein, um deinen Benutzernamen anfordern zu können! \n\nDein Benutzername wird dir anschließend per Mail zugeschickt. \n\n\nACHTUNG: Dies kann einen Moment dauern!");
        german.put("usernameRequest","Anfordern");
        //endregion

        //region Sign in
        german.put("signinTitle","Registrierung");
        german.put("name","Name");
        german.put("familyname","Nachname");
        german.put("birthday","Geburtstag");
        german.put("passwordRep","Passwort wiederholen");
        german.put("signinButton","Registrieren");
        german.put("signinDisclaimer","Alle vorhandenen Felder sind auszufüllen!");
        german.put("datepick", "Auswahl");
        german.put("gender","Geschlecht");
        //endregion

        //region Reset Password
        german.put("resetPasswordLabel","Passwort vergessen?");
        german.put("resetPasswordDescription","Gib bitte deine E-Mail Adresse ein, um dein Passwort zurücksetzen zu können! \n\nAnschließend wird dir ein zufälliger Code zugeschickt. \n\n\nACHTUNG: Dies kann einen Moment dauern!");
        german.put("resetPasswordRequest","Anfordern");
        //endregion

        //region Reset password change
        german.put("resPwChangeTitle","Passwort ändern");
        german.put("resPwNewPw","Neues Passwort");
        german.put("resPwNewPwRep","Passwort wiederholen");
        german.put("resPwConfirm","Bestätigen");
        //endregion

        //region Account verify
        german.put("accVerifyTitle","Account Bestätigung");
        german.put("accVerifyDescription","Um deinen Account zu bestätigen, gib bitte  im unteren Feld den Code, den du per Mail erhalten hast, ein. \n\nSolltest du keine Mail erhalten haben, wurde eventuell eine ungültige Mail-Adresse eingegeben.");
        german.put("accVerifyConfirm","Bestätigung");
        //endregion

        //region Imprint
        german.put("imprintTitle","Impressum");
        german.put("personalData","Entwickler-Information");
        german.put("aboutApp","Zur App");
        german.put("myData","Katharina Schury \nÖsterreich");
        german.put("copyRight","Copyright und Urheberrecht");
        german.put("crContent","Urheberrecht: \nbfi IT-L@B Kärnten \n\nCopyright: \nSämtliche Icons und Images sind von Icons8. \nVon diesen ausgenommen ist das Logo, welches selbst designed wurde." +
                        "\n\nLink:\nhttps://icons8.de/icons" +
                "\nDie Benutzung der App findet auf eigene Verantwortung hin. \nEs werden keine persönlichen Daten gesammelt!");
        //endregion

        //region Calendar
        german.put("calendarTitle","Kalenderübersicht");
        //endregion

        //region Language
        german.put("languageTitle", "Sprachauswahl");
        //endregion

        //region Short descriptions
        german.put("DescButton","Beschreibung");
        german.put("JoinButton","Beitreten");

        german.put("sepWTitle","Müll trennen");
        german.put("sepWDesc","Wo gehört was hin? \nWas gehört alles in den Plastikmüll? \nFragen, die man sich im Alltag so stellt ... \n\nHier geht es rund um das Trennen von Müll!");

        german.put("recTitle","Recycle");
        german.put("recDesc","Recycling bedeutet das Wiederverwerten alter Sachen. \n\nHier findet Ihr ein paar Tipps zum Thema Recycling!");

        german.put("upcTitle","Upcycle");
        german.put("upcDesc","Aus alt mach neu! \n\nManchmal lassen sich aus alten Sachen ganz leicht neue herstellen.");

        german.put("redPlTitle","Plastik reduzieren");
        german.put("redPlDesc","Die Ansammlung an Plastik wird immer größer … \n\nAußerdem kann es nicht abgebaut werden, weshalb es von Vorteil ist Plastik zu reduzieren.");

        german.put("nutrTitle","Ernährung");
        german.put("nutrDesc","Nahrung ist für uns alle von Wichtigkeit. Ohne Nahrung wären wir auf Dauer nicht lebensfähig.");

        german.put("veggieTitle","Vegetarisch");
        german.put("veggieDesc","Fleisch hat wie so alles im Leben seine Vor-und Nachteile ... \n\nHier ein paar Informationen, warum weniger Fleisch eine Option ist!");

        german.put("veganTitle","Vegan");
        german.put("veganDesc","Die Geister scheiden sich, was hinter Veganismus steht. \n\nEhrlich gesagt, sagen sehr viele, dass es die umweltbewussteste Ernährung ist, wogegen die anderen auf dem Gegenteil beharren.");

        german.put("reuseInfoTitle","Wiederverwenden Information");
        german.put("reuseInfoDesc","Hier findet ihr ein paar Informationen dazu, warum wir auf wiederverwendbare Alternativen umsteigen sollten!");

        german.put("reuseBagTitle","Wiederverwendbare Taschen");
        german.put("reuseBagDesc","Plastik-Sackerln lassen sich weder abbauen noch wiederverwenden ... \n\nEs gibt immer mehr Alternativen.  Warum sollten wir diese nicht nutzen?");

        german.put("reuseCupTitle","Wiederverwendbare Becher");
        german.put("reuseCupDesc","Wiederverwendbare Becher bringen nahezu nur Vorteile mit sich. \n\nWeniger Müll, auffüllbar und immer mit dabei!");

        german.put("reuseBottleTitle","Wiederverwendbare Flaschen");
        german.put("reuseBottleDesc","Wiederverwendbare Flaschen bringt jede Menge Gutes mit sich!  \n\nMan vermeidet Müll, hat immer eine Flasche dabei, welche man immer wieder auffüllen kann ...");

        german.put("resTitle","Ressourcen schonen");
        german.put("resDesc","Wir gehen viel zu achtlos mit den Ressourcen um ... \n\nEin Teil der Rohstoffe ist erneuerbar, der andere wiederrum nicht!");

        german.put("swTitle","Wasser sparen");
        german.put("swDesc","Wasser ist, wie wir alle bereits wissen, lebensnotwendig ... \n\nIn vielen Ländern der Welt herrscht Trinkwasserknappheit.");

        german.put("spTitle","Strom sparen");
        german.put("spDesc","Wir verbrauchen täglich Strom, auch an Stellen an denen wir ihn nicht mal brauchen würden ...");

        german.put("cfTitle","Autofrei");
        german.put("cfDesc","Dass Autoabgase nicht wirklich gut für die Umwelt sind, wissen wir alle ... \n\nWarum nicht mal das Auto zu Hause lassen und eine Alternative wählen?");

        german.put("conTitle","Konsumverhalten");
        german.put("conDesc","Glaubt man es oder nicht, unser Konsumverhalten trägt einiges zur Umwelt bei! \n\nWir haben alles, was wir brauchen, was wollen wir mehr?");

        german.put("zwTitle","Zero Waste");
        german.put("zwDesc","Müll reduzieren ist eine Sache, versuchen ohne Müll zu leben eine andere! \n\nDie Herausforderung besteht im Finden der Alternativen für alltägliche Produkte.");

        german.put("noStrTitle","Keine Strohhalme");
        german.put("noStrDesc","Luxus oder Notwendigkeit? \n\nNormalerweise besteht für uns keine Notwendigkeit darin, Strohalme zu verwenden - ohne geht es auch!");

        german.put("rsTitle","Regional und Saisonal");
        german.put("rsDesc","Egal wo man lebt, man hat überall eine umfangreiche Auswahl an regionalem und saisonalem Obst und Gemüse. \n\nAuf heimische Lebensmittel setzen!");

        german.put("habitsTitle","Gewohnheiten");
        //endregion

        //region Home
        german.put("homeChangeCV","Kalenderansicht ändern");
        german.put("homeMyHabits","Meine Gewohnheiten");

        german.put("monday","Montag");
        german.put("tuesday","Dienstag");
        german.put("wednesday","Mittwoch");
        german.put("thursday","Donnerstag");
        german.put("friday","Freitag");
        german.put("saturday","Samstag");
        german.put("sunday","Sonntag");

        german.put("january","Januar");
        german.put("february","Februar");
        german.put("march","März");
        german.put("april","April");
        german.put("may","Mai");
        german.put("june","Juni");
        german.put("july","Juli");
        german.put("august","August");
        german.put("september","September");
        german.put("october","Oktober");
        german.put("november","November");
        german.put("december","Dezember");
        //endregion

        //region AccountInfo
        german.put("usernameLabel","Benutzername:");
        german.put("nameLabel","Name:");
        german.put("familynameLabel","Familienname:");
        german.put("genderLabel","Geschlecht:");
        german.put("birthdayLabel","Geburtstag:");
        german.put("AccEditButton","Benutzername ändern");
        german.put("AccDeleteButton","Account löschen");
        german.put("ChangePwButton","Passwort ändern");
        //endregion

        //region Account Edit
        german.put("confirm","Bestätigen");
        german.put("oldUsername","Alter Benutzername");
        german.put("newUsername","Neuer Benutzername");
        german.put("repeatUsername","Wiederholen");
        german.put("AccEditTitle","Benuztername ändern");
        //endregion

        //region Change password
        german.put("changePwTitle","Passwort ändern");
        german.put("oldPassword","Altes Passwort");
        german.put("newPassword","Neues Passwort");
        german.put("changePwRep","Wiederholung");
        //endregion

        //region Delete Account
        german.put("deleteAccTitle","Account löschen");
        german.put("deleteAccAlert","Wir finden es sehr schade, das du dich dazu Entschlossen hast `Eco-Life` zu verlassen! "+
                "\n\nBeim löschen deines Accounts gehen alle bisher gespeicherten Daten verloren. Eine Wiederherstellung des Accountes ist daher leider nicht möglich ..."+
                "\n\nHinweis: \nFalls du dich zu einem späteren Zeitpunkt doch wieder beitreten willst, bitten wir dich daher einen neuen Account anzulegen!");
        german.put("deleteButton","Löschen");

        //endregion

        //region For all habits needed
        german.put("BackToHabits","Zurück zu den Gewohnheiten");
        german.put("JoinHabit","Beitreten");
        //endregion


        //region Separate Waste
        german.put("sepWasteTitle","Müll trennen");
        german.put("sepWasteContent1","Müll trennen ist zwar aufwendig, bringt aber viele Vorteile mit sich! \nDurch das richtige trennen von Müll, kann dieser leichter recycelt und weiterverarbeitet werden. "+
                        "\n\nDurch die Achtlosigkeit der Menschheit, gelangen jährlich Unmengen an Müll, ebenso an Plastik, in die Umwelt ... "+
                        "\n\nDie Müllansammlung ist mittlerweile schon doppelt so groß wie Frankreich!"+
                        "\nZum besseren Verständnis - das sind dann ca. 1287,902 Quadratkilometer."+
                         "\n\nMein Rat:"+
                        " \nAn alle die Müll trennen wollen, informiert euch bitte auch selbst wie das in eurem Land oder eurer Stadt gemacht wird, das dies leider nicht überall einheitlich ist."+
                      "\nHier stelle ich Informationen bereit wie es beispielsweise in Österreich gehandhabt wird!");
        german.put("wasteSeparation","Zur Müllaufteilung");

        german.put("plastic","Plastik");
        german.put("residual","Restmüll");
        german.put("paper","Papier");
        german.put("glass","Glas");
        german.put("eco","Biomüll");
        german.put("other","Anderer Müll");
        german.put("sepWasteHint","Metallmüll wird in der Kategorie Plastik beschrieben!");

        german.put("plasticTitle","Plastik");
        german.put("headlineBottles","Plastikflaschen für:");
        german.put("contentBottles","Getränke (PET) \nWasch-und Putzmittel \n-Weichspüler, Haushaltsreiniger, Glasreiniger \nSonstige Lebensmittelflaschen \n-Essig, Öl, Milch...\n" +
                "\nDestiliertes Wasser, Kühlmittel, Sonstiges... \n-KEIN Motoröl" +
                "\nKörperpflegemittel");
        german.put("headlineTins","Dosen, kleinteilige Metalle:");
        german.put("contentTins","Getränkedosen \nKonservendosen \n-Lebensmittel, Tiernahrung \nMenüschalen aus Metall "+
                        "\n-Fertiggerichte, Tiernahrung \nAndere Metallverpackungen wie: \n-Verschlüsse, Deckel, Tuben, Alufolie "+
                        "\nKleine Metalle \n-Durchmesser kleiner 20cm, nicht spitz/scharf "+
                "\n-Keine Batterien/Drähte");
        german.put("headlinePacks","Getränkekartons:");
        german.put("contentPacks","Saft und Milch in Tetra-Packs \nGetränkekartons für Wein etc.");


        german.put("residualTitle","Restmüll");
        german.put("generallyIn","Grundsätzlich gilt:");
        german.put("residualContent","Produkte die keiner weiteren Entsorgung beigeführt werden können "+
                        "\n\nJene die frei von Schad-und Giftstoffen - also solche die keine gefährlichen Inhaltsstoffe enthalten. "+
                "\n\nMüll der nicht sperrig ist.");

        german.put("paperTitle","Papier");
        german.put("paperContent","Zeitungen, Illustrierte, Kataloge, Prospekte "+
                        "\n\nSchreibpapier, Kuverts (mit und ohne Sichtfenster) "+
                        "\n\nHefte, Telefonbücher "+
                        "\n\nUnbeschichtete Tiefkühlkartons "+
                        "\n\nWellpappe" +
                        "\n\nPapiersäcke, Kartonagen, Schachteln - Bitte mit Papier füllen oder entfalten!");
        german.put("paperHint","Hinweis");
        german.put("paperHintContent","Nur weil etwas offensichtlich scheint muss es noch lange nicht so sein." +
                "\nGroße Kartonagen gehören zum Beispiel nicht in den Papiermüll sondern auf den Mistplatz!");

        german.put("glassTitle","Glas");
        german.put("whiteglassTitle","Weißglas");
        german.put("whiteglasssContent","Ungefärbte Einwegflaschen, ungefärbte Konservengläser" +
                        "\n\nUngefärbte Kondensmilch- und Limonadenflaschen" +
                        "\n\nUngefärbte Wein und Spirituosenflaschen" +
                          "\n\nUngefärbte Glasflakons");
        german.put("coloredglassTitle","Buntglas");
        german.put("coloredglassContent","Gefärbte Einwegflaschen, gefärbte Konservengläser" +
                        "\n\nGefärbte Wein-und Spirituosen- und Limonadenflaschen" +
                        "\n\nGefärbte Glasflakons" +
                      "\n\nAuch leicht gefärbtes Glas ist Buntglas");

        german.put("ecoTitle","Biomüll");
        german.put("ecoContent","Aus dem Garten:\n" +
                "\nRasenschnitt, Laub, Baum-und Strauchschnitt, Ernterückstände, Stauden, Fallobst, Wasserpflanzen\n" +
                "\n\nAus Küche und Haus:\n" +
                "\nUngewürzte und ungekochte Obst-und Gemüseabfälle, Pflanzen mit geringer Menge anhaftender Blumenerde im Wurzelbereich, alte Brotreste, Tee-und Kaffesud\n" +
                "\n\nGrundsätzlich gilt das nur die Abfälle, die man auch auf den Kompost geben würde.\n" +
                "\n\nChristbäume (bis 1,5m)");
        german.put("ecoHint","Hinweis");
        german.put("ecoHintContent","Nicht alles das Logisch erscheint gehört hinein!\n" +
                "\n\nFleisch, Speisereste, Knochen etc. gehören in den Restmüll, ebenso wie Wurzelstöcke, größere Mengen an Grünschnitt...\n" +
                "\n\nWenn man sich bei manchen Dingen unsicher ist, besser selbst nochmal nachschauen wie es dort wo man lebt gehandhabt wird.");

        german.put("otherTitle","Anderer Müll");
        german.put("otherContent","Textilien gehören beispielsweise in die Altkleider-Sammlung. \nAlternativ können sie an Hilfseinrichtungen gespendet werden.\n" +
                "\n\nAlte und abgelaufene Medikamente werden am besten wieder zurück in die Apotheke bringen, da sie dort richtig entsorgt werden können.\n" +
                "\n\nBatterien, Elektrogeräte etc. gehören zur Problemstoffsammlung.\n" +
                "\n\nMehrwegflaschen und Kisten mit Pfand nimmt der Handel wieder zurück.\n" +
                "\n\n\nNatürlich gilt auch hier wieder, bei Unsicherheiten bitte online nachschlagen und sich informieren wie es im eigenen Land und Ort geregelt ist.\n" +
                "\n\nWo in Deutschland Pfand auf Plastikflaschen ist, wird in Österreich  kein Pfand aufgerechnet und die Möglichkeit, Flaschen wieder ins Geschäft zu bringen, fällt weg.");
        //endregion

        //region Recycle
        german.put("recycleTitle","Recycle");
        german.put("recHeadlineText","Beim Kauf auf Mehrwegflaschen anstelle von PET-Flaschen achten!");
        german.put("recFirstPoint","Produkte, wenn möglich, reparieren statt wegwerfen!");
        german.put("recFirstUnderpoint","Spart Geld, reduziert Müll.");
        german.put("recSecondPoint","Langlebige Produkte kaufen!");
        german.put("recThirdPoint","Ausleihen und benutzen statt besitzen!");
        german.put("recThirdUnderpoint","Bei Werkzeugen/Waren, die man einmalbenötigt. \n\nBücher/Filme: Bücher in einer Bibliothek und Filme in Videotheken. \n\nAuch möglich bei Kostümen und diverser Sportausrüstung.");
        german.put("recFourthPoint","Flohmarkt und Tauschbörse!");
        german.put("recFourthUnderpoint","Es besteht die chance billiger an bestimmte Sachen zu kommen, wie z.B. Bücher, Spiele, Spielzeug, Dekoration... \n\nMit alten, gut erhaltenen Sachen Geld verdienen" +
                "                    \n\nWas der eine wegwirft, bereitet dem nächsten Freude. Obendrein wird dadurch sogar noch Müll reduziert.");
        german.put("recFifthPoint","Akku statt Batterie!");
        german.put("recFifthUnderpoint","Langlebiger und umweltfreundlicher");
        german.put("lastPoints","Jausenbox statt Plastiksackerl!" +
                "\n\nVerpackungen vermeiden!" +
                "\n\nWiederverwendbare Alternativen nutzen!" +
                " \n\nBraucht man das wirklich?");
        //endregion

        //region Upcycle
        german.put("upcylceTitle","Upcycle");
        german.put("upcycleContent","Es ist super einfach aus alten Sachen, etwas neues zu schaffen!" +
                "\n\nWer kennt es nicht?" +
                "\nMan hat jede menge alten Kram zu Hause rumliegen den keiner mehr will oder braucht..." +
                "\n\nDer Kleiderschrank ist voll und man hat nichts zum Anziehen?" +
                "\nEin Grund dafür kann sein, das man alte Kleidung die man nicht mehr trägt, hortet - davon trennen kann man sich allerdings auch nicht..." +
                "\n\nDas ist wo 'Upcycling' ins Spiel kommt!" +
                "\nMan verwertet einfach seine alten Sachen in etwas neues und individuelles - etwas das sonst, so auf diese Art, noch niemand bei sich zu Hause hat!" +
                "\n\n\nHier unten findet Ihr ein paar tolle Links zu Upcycling-Ideen!");
        german.put("firstLink","Handmade Kultur");
        german.put("secondLink","DIY Academy");
        german.put("thirdLink","DIY Mode");
        //endregion

        //region Reduce Plastic
        german.put("redPlasticTitle","Plastik reduzieren");
        german.put("redPlasticWhy","Warum?");
        german.put("redPlasticWhyContent","Plastik kann nicht abgebaut werden. Durch die unachtsame Entsorung von Plastikmüll, gelangt dieser vermehrt in die Ozeane und Meere...\n" +
                        "\n\nFische und andere Meereslebewesen verfangen sich anschließend darin und sterben in Folge qualvoll.\n" +
                        "\nOft werden die Meereslebewesen auch mit dem ganzen Plastikmüll an Land geschwemmt und vertrocknen daraufhin in der Sonne...\n" +
                        "\n\nDas Plastik in der Umwelt betrifft allerdings nicht nur Meereslebewesen, sonder auch Tiere an Land!\n" +
                        "\nUnbewusst konsumieren Tiere das Plastik das in der Umwelt verstreut liegt, wodurch es in ihren Organismus gelangt...\n" +
                        "\n\nWusstet Ihr, das sogar wir Menschen bereits Plastik in unserem Blutkreislauf haben?");
        german.put("redPlasticWhat","Was kann man selbst tun?");
        german.put("partOne","Überflüssige Einwegprodukte vermeiden!" +
                        "\n\nUnverpackt Läden!" +
                        "\n\nWiederverwendbares statt Einweg!" +
                        "\n\nObst und Gemüse lose kaufen!" +
                "\n\nEigene Mehrwegbehälter mitbringen!");
        german.put("partTwo","Bei einem Coffee to go oder Essen zum Mitnehmen");
        german.put("partThree","Auf Inhaltsstoffe achten!");
        german.put("partFour","Acryclate Copolymer(AC); Polyamide(PA); Siloxane" +
                        "\nPolyethylen(PE); Polypropylen(PP); Polyethylenterephtalat(PET)" +
                "\n - Sind Mikroplasik");
        german.put("partFive","Feste Shampoos, Seifen und Spülungen!");
        german.put("partSix","Sie haben weniger oder in manchen Fällen keine Umverpackungen.");
        german.put("partSeven","Kleidung Naturmaterial statt Synthetik!\n" +
                "\n\nMüll sammeln und trennen!");
        german.put("redPlasticLink","Nachhaltig-Sein.info");
        //endregion

        //region Nutrition
        german.put("nutritionTitle","Ernährung");
        german.put("nutrIG","Allgemein");
        german.put("nutrIGContent","Nahrung ist lebensnotwendig, ohne Lebens- und Nahrungsmittel könnten wir nicht auskommen." +
                "\nUnser Körper braucht für alle täglichen Aktivitäten, Arbeiten und Körperfunktionen Energie. Diese Energie erhalten wir durch Essen und Schlafen." +
                "\n\nIn der Nahrung sind auch viele gesunde Inhaltsstoffe, wie z.B. Mineralien, Vitamine und Spurenelemente vorhanden." +
                "\nDurch diese Inhaltsstoffe wird unser Immunsystem gestärkt und viele Krankheiten vorgebeugt." +
                "\n\nMit der richtigen Lebensweise und einer gesunden Ernährung können auch Volkskrankheiten vorgebeugt werden.");
        german.put("nutrTipps","Tipps");
        german.put("nutrOne","Frisch kochen anstelle von Fertiggerichten!" +
                "\n\nObst und Gemüse nach Möglichkeit selbst anbauen!" +
                "\n\nKräuter selbst anbauen bzw. in Blumentöpfen einpflanzen!" +
                "\n\nLokal und saisonal einkaufen!");
        german.put("nutrTwo","\"Auf Siegel achten" +
                "\n\nNachschlagen was wann aktuell ist");
        german.put("nutrThree","Fleisch reduzieren!");
        german.put("nutrFour","Auf Gütesiegel achten" +
                        "\n\nLokale Bauern vorziehen" +
                "\n\nAuf artgerechte Tierhaltung achten, Massentierhaltung vermeiden");
        german.put("nutrFive","Auf Freiland Siegel achten!");
        german.put("nutrSix","Bei Eiern" +
                "\n\nMilch - von Kühen die auch mal frische Luft zu atmen und frisches Gras zu fressen bekommen.");
        german.put("nutrSeven","Auf Transportwege achten!" +
                "\n\nBio- oder Wochenmärkte besuchen!" +
                "\n\nVorteil regionaler und saisonaler Ernährung!");
        //endregion

        //region Vegetarian
        german.put("vegTitle","Vegetarisch");
        german.put("vegIg","Allgemein");
        german.put("vegIgContent","Für die Zucht von Fleisch werden stätig Wälder gerodet, wie auch Ur-und Regenwälder die für uns notwendigen Sauerstoff produzieren." +
                "\nPro Kilo Fleisch beträgt der CO² Ausstoß ca. 36kg, dafür alleine werden dann 10kg Getreide benötigt." +
                "\n\nDer Großteil unseres Fleisches stammt aus Massentierhaltung, bemüht man sich hingegen um Fleisch artgerechter Haltung, ist dies gesünder." +
                "\nDurch die im Fleisch enthaltenen Fette, vor allem gesättigten Fettsäuren, steigt das schlechte Cholesterin schneller an." +
                "\n\nFleisch, insbesondere Schweinefleisch, enthält meist Antibiotika. Durch den regelmäßigen Konsum von mit Antibiotika versetztem Fleisch, laufen wir Gefahr im Krankheitsfall gegen diese resistent zu sein.");
        german.put("vegAdv", "Welche Vorteile hat Fleisch?");
        german.put("vegOne","Hochwertiges Eiweiß!");
        german.put("vegTwo","Wird zur Erzeugung von Energie und für viele Körperfunktionen benötigt.");
        german.put("vegThree","Wichtige Vitamine A und B!");
        german.put("vegFour","Ein Mangel führt zu: " +
                "\nMuskelschwund \nHerzinsuffizienz " +
                "\nSchlafstörungen \nAppetitlosigkeit \nBlutarmut");
        german.put("vegFive","Versorgt mit Mineralstoffen und Eisen!");
        german.put("vegSix","Ohne Eisen sind wir Antriebslos, müde und unser Immunsystem wird geschwächt." +
                "\n\nWar schon immer Bestandteil der Nahrung!");
        german.put("vegSeven","Lebensgrundlage für viele Landwirte!");
        //endregion

        //region Vegan
        german.put("vegan_Title","Vegan");
        german.put("veganIg","Allgemein");
        german.put("veganIgContent","Um hier Informationen zum Thema Veganismus bereitstellen zu können, habe ich mich umfangreich informiert." +
                "\n\nEin großes Thema ist die Meinungsverschiedenheit der Leute, aber auch der 'Blödsinn' der im Internet verbreitet wird." +
                "\n\nLiest man sich all das genau und sinnergreifend durch, fällt einem das nur bald auf!" +
                "\n\nGründe die genannt wurden, waren oft die Umwelt oder auch die eigene Gesundheit." +
                "\n\nAlles in allem ist das meiste ein Wiederspruch in sich selbst!Tierische Erzeugnisse haben Inhaltstoffe die für den Menschen ebenso essentiell sind, wie jene die in Pflanzlichen Erzeugnisse enthalten sind!");
        german.put("veganWhy","Gründe warum Vegan doch okay sein kann!");
        german.put("veganOne","Bei Allergien und Unverträglichkeiten gegen Tierische Eiweiße!");
        german.put("veganTwo","Es gibt Menschen die tatsächlich keine Tierischen Eiweiße vertragen, wodurch sie solche auch nicht zu sich nehmen können");
        german.put("veganThree","Ethnische Gründe!");
        german.put("veganFour","Sei es die Tierliebe, die nahezu Grenzen überschreitet, der Mord an Nutztieren oder auch die sogenannte Ausnutzung!");
        german.put("veganFive","Verzicht auf Antibiotika haltige Tierprodukte!");
        german.put("veganSix","Alternativ kann man natürlich auch auf die Herkunft achten." +
                "\n\nEs ist keine Frage das gewisse Tierische Produkte mit Antibiotika vollgepumpt werden, aber dadurch lässt sich dieser Fakt noch lange nicht auf alles andere ableiten!");
        german.put("veganVeryImp","!!!SEHR WICHTIG!!!");
        german.put("veganVeryImpContent","Rede mit deinem Arzt über die geplante vegane Ernährung, lass dein Blutbild regelmäßig kontrollieren und Freunde dich mit dem Gedanken an, Nahrungsergänzungsmittel und Vitamine einnehmen zu müssen!");
        german.put("veganLinks","Informative Websites");
        german.put("veganLinksContent","Wenn du mehr über das ganze Thema erfahren willst, hab ich dir hier unten ein paar Links eingefügt!");
        german.put("veganLink1","Gesund oder Riskant?");
        german.put("veganLink2","Wie gesund ist Vegan?");
        german.put("veganLink3","Wie gesund ist Vegan 2.0");
        german.put("veganLink4","Warum Vegan?");
        german.put("veganLink5","Veganblatt.com");
        //endregion

        //region Reuse Info
        german.put("reuseInfTitle","Wiederverwenden Information");
        german.put("reuseInfWhy","Warum?");
        german.put("reuseInfWhyContent","Ein guter Weg die Müllberge zu reduzieren, ist die Verwendung wiederverwendbarer Gegenstände. Auf diese Art und Weise werden auch Ressourcen geschont, da nicht laufend neue Ware produziert werden muss." +
                "\n\nDie Alternativen zu den Einweg - Produkten sind gewiss langlebiger und im Schnitt auf die Dauer aufgerechnet sogar günstiger.");
        german.put("reuseInfAlt","Warum Alternativen besser sind!");
        german.put("reuseInf1","Waschbar!");
        german.put("reuseInf2","Es kommt darauf an zu welchem Produkt man die Alternative  verwendet." +
                "\n\nJe nachdem sind sie Waschmaschinen oder Spülmaschinen geeignet!");
        german.put("reuseInf3","Längere Lebensdauer!");
        german.put("reuseInf4","Im Gegensatz zu den Plastik-Einwegprodukten kann man sie über mehrere Jahre hinweg verwenden!" +
                "\n\nDurch die erhöhte Lebensdauer, können Alternativen immer wieder verwendet werden, weil sie sich auch wesentlich langsamer abnützen als das Einweg-Produkt.");
        german.put("reuseInf5","Umweltfreundlicher!");
        german.put("reuseInf6","Man wirft weniger weg, und es muss im Anschluss dafür weniger nachproduziert werden.");
        german.put("reuseInf7","Günstiger!");
        german.put("reuseInf8","In der ersten Anschaffung mag es eventuell teurer vorkommen, aber wenn man dann mal einen Moment nachdenkt und nachrechnet merkt man, das über die Dauer gesehen, die Alternativen günstiger sind.");
        german.put("reuseInfWhySwitch","Wir sollten auf Alternativen umsteigen weil ...");
        german.put("reuseInfRes1","Müllansammlung doppelt so groß wie Frankreich!");
        german.put("reuseInfRes2","Frankreich hat eine Fläche von 643,801 km², rechnet man also das Doppelte aus erhält man eine Fläche von 1287,602 km².");
        german.put("reuseInfRes3","Schwer bis gar nicht abbaubar!" +
                "\n\nWird nicht recycelt!");
        //endregion

        //region Reuse Bag
        german.put("rBagTitle","Wiederverwendbare Taschen");
        german.put("rBagIntr","Einleitung");
        german.put("rBagIntrContent","Die Plastik-'Sackerln' die man in jedem Laden um ein paar Cent bekommt, oder beim Obst und Gemüse kostenlos zum Einpacken und abwägen der Ware erhältlich sind, haben eine sehr kurze Lebensdauer und sind außerdem nicht lang wiederverwendbar." +
                "\n\nIn der Theorie kann man diese Plastiksäcke öfter als nur einmal wiederverwenden. Allerdings sind diese nicht so stabil und langlebig wie die Alternativen die es gibt. ");
        german.put("rBagAlt","Welche Alternativen gibt es?");
        german.put("rBagAltContent","Jute" +
                        "\n\nStoff/e" +
                        "\n\nLeinen" +
                        "\n\nBaumwolle" +
                        "\n\nWiederverwendbare Polypropylentaschen" +
                        "\n\nMaschenbeutel" +
                "\n\nNetztaschen");
        //endregion

        //region Reuse Cup
        german.put("rCupTitle","Wiederverwendbare Becher");
        german.put("rCupIntr","Einleitung");
        german.put("rCupIntrContent","Durch zahlreiche Möglichkeiten die uns heute geboten werden, wird es immer einfacher, auf wiederverwendbare Alternativen umzusteigen." +
                        "\n\nWenn man sich regelmäßig, oder nur hin und wieder, einen Coffee to go holt oder ein anderes Heißgetränk bekommt man standartmäßig einen, mit Plastik beschichteten, Pappbecher mit Plastikdeckel." +
                "\n\nBei kalten Getränken ist es dann meist ein transparenter Plastikbecher!");
        german.put("rCupAlt","Welche Alternativen gibt es?");
        german.put("rCupAltContent","Thermobecher aus Alu oder Glas" +
                        "\n\nHartplastik-/Kunststoffbecher" +
                        "\n\nKeramik" +
                        "\n\nBambus" +
                        "\n\nGlas" +
                        "\n\nEdelstahl" +
                "\n\nSilikon");
        german.put("rCupAltContent2","Besonders platzsparend weil sie meistens auch zusammenfaltbar sind.");
        //endregion

        //region Reuse Bottle
        german.put("rBottleTitle","Wiederverwendbare Flaschen");
        german.put("rBottleIntr","Einleitung");
        german.put("rBottleIntrContent","Es gibt genug Materialien die wesentlich langlebiger, und besser zu reinigen sind als PET-Flaschen aus dem Supermarkt! Plastikflaschen sind im Grunde nicht darauf ausgelegt worden, immer und immer wieder zu verwenden." +
                        "\n\nDa Plastik kaum an Gewicht besitzt, eignen sich Plastikflaschen am besten für den Verkauf an Getränken." +
                        "\n\nEin weiterer Punkt ist der Preis!" +
                "\n\nVergleich man Smoothies aus Glasflaschen, sind diese deutlich teurer, als jene, die in Plastikflaschen verkauft werden.");
        german.put("rBottleAlt","Welche Alternativen gibt es?");
        german.put("rBottleAltContent","Thermoflaschen aus Alu oder Glas" +
                        "\n\nHartplastik-/Kunststoff" +
                        "\n\nZuckerrohr" +
                        "\n\nBambus" +
                        "\n\nGlas" +
                "\n\nEdelstahl");
        //endregion

        //region Spare resources
        german.put("srTitle","Ressourcen schonen");
        german.put("srWhat","Was sind Ressourcen?");
        german.put("srWhatContent","Ressourcen sind ein natürlich vorkommender Bestand, wie beispielsweiße Holz, Kohle, Wasser ..." +
                "\n\nSie gliedern sich in erneuerbare und nicht erneuerbare Rohstoffe. Der Umwelt zuliebe sollten wir auf diese Rohstoffe achten und sparsam mit ihnen umgehen.");
        german.put("srTipps","Tipps");
        german.put("srTipp1","Rückseite nicht mehr gebrauchter Zettel als Schmierzettel verwenden!");
        german.put("srTipp1a","Warum, für ein paar schnelle Kritzeleien, ein neues Blatt Papier nehmen, wenn man die Rückseite eines Blattes nimmt, das man nicht mehr braucht?");
        german.put("srTipp2","Dokumente, Arbeitsblätter, Urkunden beidseitig bedrucken!");
        german.put("srTipp2a","So spart man nicht nur Papier und in gewisser Art und Weise auch Platz, sondern auch Ressourcen.");
        german.put("srTipp3","Wasser aus beim Zähne putzen/Haare waschen!" +
                        "\n\nHeizen nur wenn kalt ist!" +
                "\n\nAuf Siegel achten!");
        german.put("srTipp3a","Ob Produkt umweltfreundlich hergestellt wurde oder aus  recyceltem Material besteht.");
        german.put("srTipp4","Selbst Recyceln oder Upcyceln!" +
                        "\n\nRichtiges Lagern von Lebensmitteln!" +
                        "\n\nKaufen was man auch wirklich braucht!" +
                "\n\nLebensmittel nach Mindesthaltbarkeitsdatum überprüfen!");
        german.put("srTipp4a","Das Mindesthaltbarkeitsdatum (MHD) ist von der Lebensmittelindustrie vorgeschrieben und gibt an wie lange ein Lebensmittel MINDESTENS haltbar ist." +
                "\nAuch Lebensmittel die nicht ablaufen oder verderben können müssen daher mit einem Mindesthaltbarkeitsdatum versehen werden.");
        german.put("srTipp5","Foodsharing!");
        german.put("srTipp5a","Lebensmittel an Verwandte, Bekannte oder Nachbarn weitergeben, wenn man über mehrere Tage nicht zu Hause ist.");
        german.put("srTipp6","Second hand!");
        //endregion

        //region Zero Waste
        german.put("zeroWasteTitle","Zero Waste");
        german.put("zwContent","Da die Müllansammlung immer weiter wächst, obwohl sie ohnehin schon gewaltig groß ist, ist es an der Zeit wirklich umzudenken!" +
                "\n\nMüll reduzieren ist eine Sache, versuchen mit möglichst ohne Müll zu leben, eine andere!");
        german.put("zwHow","Wie geht Zero-Waste?");
        german.put("zwHow1","Zu einem Teil gehört das Konsumverhalten auch in Zero-Waste einbezogen, da man es als Kunde in der Hand hat, welche Produkte in" +
                " den Warenkorb kommen und welche nicht!");
        german.put("zwHow1a","Auf Glas- oder andere Wiederverwendbare Verpackungen achten. " +
                "\n\nAuf unnötige Verpackungen verzichten.");
        german.put("zwAlternatives","Alternativen");
        german.put("zwOriginals","'Original'");

        german.put("zwAlt1","Rasierhobel");
        german.put("zwOrg1","Einwegrasierer");

        german.put("zwAlt2","Deo-Creme");
        german.put("zwOrg2","Deo-Spray");

        german.put("zwAlt3","Bambus-Zahnbürste");
        german.put("zwOrg3","Plastikzahnbürste");

        german.put("zwAlt4","Guter ganzer Kaffee");
        german.put("zwOrg4","Kapselkaffee");

        german.put("zwAlt5","Wachspapier");
        german.put("zwOrg5","Alufolie");

        german.put("zwAlt6","Stoffbeutel");
        german.put("zwOrg6","Plastiktaschen");

        german.put("zwAlt7","Salat selbst richten");
        german.put("zwOrg7","Fertige Salate");

        german.put("zwAlt8","Besteck mitbringen");
        german.put("zwOrg8","Plastik Besteck");

        german.put("zwAlt9","Glasflasche");
        german.put("zwOrg9","PET-Flasche");

        german.put("zwAlt10","Essen mitbringen");
        german.put("zwOrg10","Essen von Imbiss-Buden");

        german.put("zwAlt11","Feste Zahnpasta/Kapseln");
        german.put("zwOrg11","Zahnpasta aus der \nTube");

        german.put("zwAlt12","Waschbare Taschentücher");
        german.put("zwOrg12","Wegwerf  \nTaschentücher");

        german.put("zwAlt13","Unverpackte Naturseife  aus Reformhaus oder Bio-Laden");
        german.put("zwOrg13","Flüssigseife, \nmehrfach verpackte feste Seife");

        german.put("zwAlt14","Rasierseife");
        german.put("zwOrg14","Rasierschaum/-gel");

        german.put("zwAlt15","Feste Seife");
        german.put("zwOrg15","Duschgel");

        german.put("zwAlt16","Haarseife und feste Spülung");
        german.put("zwOrg16","Shampoo und Contitioner");

        german.put("zwAlt17","Waschbare Reinigungspads");
        german.put("zwOrg17","Einweg Wattepads\n");

        german.put("zwAlt18","Waschpulver");
        german.put("zwOrg18","Flüssig Waschmittel");

        german.put("zwAlt19","Bambus/Edelstahl Ohrreiniger");
        german.put("zwOrg19","Wattestäbchen\n");

        german.put("zwAlt20","Peeling-Seifen");
        german.put("zwOrg20","Peeling aus der Tube");

        german.put("zwAlt21","Bürsten und Kämme aus Naturmaterialien");
        german.put("zwOrg21","Bürsten und Kämme aus Plastik ");

        german.put("zwAlt22","Wiederverwendbare Strohhalme");
        german.put("zwOrg22","Plastik Strohhalme \n");

        german.put("zwAlt23","Keine Werbung aufkleber \n");
        german.put("zwOrg23","Gegen unnötige Werbung");

        german.put("zwAlt24","Pfandflaschen");
        german.put("zwOrg24","Einwegflaschen");

        german.put("zwAlt25","Menstruationstasse");
        german.put("zwOrg25","Tampons");

        german.put("zwAlt26","Auswaschbare Binden/Slipeinlagen/Schwämmchen");
        german.put("zwOrg26","Einweg Damenhygieneprodukte \n");
        german.put("zwHacks","Zero-Waste Tipps");
        //endregion

        //region Save Power
        german.put("spTitel","Strom sparen");
        german.put("spContent","Strom wird in der heutigen Zeit täglich gebraucht. Sei es zum Kochen, Heizen oder für die Arbeit - ohne Strom würde alles Still stehen!" +
                "\n\nEin guter schritt in die richtige Richtung ist es, darauf zu achten, woher der Strom kommt!");
        german.put("spEcological","Ökologisch");
        german.put("spNotEcological","Nicht ökologisch");
        german.put("spEco1","Windenergie");
        german.put("spEco2","Solarenergie");
        german.put("spEco3","Wasserenergie");
        german.put("spNEco1","Atomenergie");
        german.put("spTipTitle","Tipps");
        german.put("spTipContent","Unter Tags kein Licht einschalten!" +
                        "\n\nUnnötiges Licht ausschalten!" +
                        "\n\nEinheizen nur wenn kalt ist!" +
                        "\n\nIm Sommer Haare Lufttrocknen statt Föhnen!" +
                        "\n\nRadio, TV und PC nur dann einschalten, wenn man ihn auch verwendet!" +
                        "\n\nHandy, iPod, Tablet nur so lange laden bis der Akku voll ist!" +
                        "\n\nNicht gebrauchte Geräte vom Strom nehmen" +
                        "\n\nLadegeräte immer abstecken!" +
                        "\n\nWäsche aufhängen statt in den Wäschetrockner geben - Insbesondere im Sommer und bei Schönwetter!" +
                        "\n\nKühl- und Gefrierschräke regelmäßig abtauen!" +
                        "\n\nKühlschrank nicht neben Wärmequellen aufstellen!" +
                        "\n\nRestwärme von Herd und Bügeleisen ausnutzen! " +
                        "\n\nTrockner und Waschmaschine erst dann einschalten, wenn sie auch wirklich voll sind!" +
                "\n\nKühlschrank immer gleich wieder schließen!");
        //endregion

        //region Save Water
        german.put("swTitel","Wasser sparen");
        german.put("swContent","Wasser ist mit eine der Lebensnotwendigsten Ressourcen, die es gibt - insbesondere sauberes Trinkwasser." +
                "\n\nIn den meisten - vor allem ärmeren - Ländern herrscht Trinkwasser Knappheit.");
        german.put("swTips","Tipps");
        german.put("swTipsContent","Wasser aus beim Zähne putzen!" +
                        "\n\nWasser aus beim Haare waschen!" +
                        "\n\nKurze duschen!" +
                        "\n\nÖfter duschen als baden!" +
                        "\n\nMehr Wäsche auf einmal waschen!" +
                        "\n\nGeschirrspüler nur dann einschalten wenn er auch wirklich voll ist!" +
                        "\n\nWenig Geschirr und Besteck von Hand abwaschen!" +
                        "\n\nRegenwasser in Tonnen sammeln und zum Giesen von Garten und Blumen verwenden!" +
                "\n\nObst und Gemüse in einer Schüssel waschen!");
        german.put("swLink","Die 10 besten Wasser-Spar Tipps!");
        //endregion

        //region Car-Free
        german.put("carFreeTitle","Autofrei");
        german.put("carFreeContent","Dass Autoabgase für die Umwelt nicht gut sind, wissen wir alle!" +
                "\n\nDa man nicht immer ein Auto braucht, lohnt es sich auf mehreren Wege, auch mal das Auto in der Garage stehen zu lassen.");
        german.put("carFreeOptions","Welche Möglichkeiten gibt es?");
        german.put("carFreeOptionsContent","Kurze Wege mit dem Rad oder zu Fuß zurücklegen!" +
                        "\n\nFahrgemeinschaften bilden!" +
                        "\n\nÖffentliche Verkehrsmittel nutzen" +
                        "\n\nFür weitere Wege den Zug nehmen!" +
                "\n\nÖfter mit dem Rad fahren!");
        //endregion

        //region Consumer-Behavior
        german.put("cbTitle","Konsumverhalten");
        german.put("cbContent","Glaubt man es oder auch nicht, aber unser Konsumverhalten hat einiges mit dem Thema Umwelt zu tun!" +
                        "\nUm diverse Lebensmittel anbauen zu können, werden teils Regenwälder gerodet." +
                "\n\nWaren, wie auch Lebensmittel, werden im Überfluss produziert und im Anschluss dann weggeworfen.");
        german.put("cbQuestions","Fragen vor dem Kauf!");
        german.put("cbQContent1","Braucht man das?" +
                        "\n\nWas habe ich noch alles zu Hause?" +
                        "\n\nVerbrauche ich das?" +
                        "\n\nWelchen Nutzen erfüllt es?" +
                        "\n\nIst der Import dieser Ware wirklich nötig?" +
                "\n\nGibt es eine regional produzierte Alternative hierzu?");
        german.put("cbQContent2","Oder gibt es eine gleichwertige Alternative mit geringerem Importweg?");
        german.put("cbQContent3","Was ist notwendig und was ist Luxus?" +
                "\n\nMuss ich als Konsument wirklich kurz vor Ladenschluss noch ofenfrische Ware erhalten?");
        //endregion

        //region No straws
        german.put("noStrawsTitle","Keine Strohhalme");
        german.put("noStrawsContent","Da Strohhalme für uns keine Notwendigkeit sind, dienen Sie hauptsächlich zur Dekoration von Getränken und als kleiner Luxus zwischendurch." +
                "\n\nIn seltenen Fällen sind Strohhalme nicht nur sehr praktisch sondern auch schon wieder fast Notwendig!");
        german.put("noStrawsAlternatives","Alternativen");
        german.put("noStrawsAltContent","Bambus" +
                        "\n\nGlas" +
                        "\n\nEdelstahl" +
                        "\n\nMakkaroni" +
                "\n\nPapier");
        //endregion

        //region Local and Seasonal
        german.put("localSeasonalTitle","Regional und Saisonal");
        german.put("localSeasonalContent","Wer regional und saisonal einkauft, vermeidet lange Transportwege und in Glashäusern gezüchtetes Obst und Gemüse." +
                "\n\nDurch den Saisonalen und Regionalen Anbau der Ware, werden weniger Gift und Schadstoffe benötigt, welche die Lebensmittel konservieren und" +
                " länger haltbar machen sollen, außerdem bleiben mehr der gesunden Inhaltsstoffe erhalten.");
        german.put("lsLink1","Österreich");
        german.put("lsLink2","Deutschland");
        german.put("lsLink3","Warum?");
        //endregion

        //region MyHabits
        german.put("myHabitsTitle","Meine Gewohnheiten");
        //endregion

        //region Push notification
        german.put("title","Hast du heute nach deinen Gewohnheiten gelebt?");
        german.put("content","Vergiss nicht, deine Gewohnheiten anzuhaken!");
        //endregion


        german.put("","");
        german.put("","");

    }

    public static String get(String key) {
        if(currentLanguage == Lang.GERMAN) {
            return german.get(key);
        }else if(currentLanguage == Lang.ENGLISH) {
            return english.get(key);
        }

        return "lang not found";
    }

    public static Lang getCurrentLanguage() {
        return currentLanguage;
    }
}
