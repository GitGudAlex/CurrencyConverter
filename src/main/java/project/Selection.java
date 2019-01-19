package project;

public class Selection {


    public static String currency(String toSell, String toBuy, boolean selectedAmount, double enteredAmount, double convertedAmount, String input) {
        String header = "";
        String[] sdrValue;
        boolean running = false;
        int counter = 0;

        final String selectionStart = "0: Select currency to buy: \n1: Select currency to sell: \n2: Choose amount to be converted:";
        final String exitStart = "Please choose an option (>>x<< to exit)";
        final String selection = "Enter a currency´s name or part of it (>>xxx<< to exit):";
        final String select = "Select a currency by index:";
        String inputSelection;
        inputSelection = input;

        if (!selectedAmount) {
            header = Header.headerOne(toSell, toBuy);

        } else if (selectedAmount) {
            header = Header.headerTwo(toSell, toBuy, enteredAmount, convertedAmount);
        }

        System.out.println(header + "\n" + selectionStart + "\n\n" + exitStart + "\n" + selection);

        input = Input.getInput();


        while (!Helper.correctInput(input)) {
            System.out.println("currency does not exist. Please try again");
            input = Input.getInput();
        }

        if (!input.equals("xxx")) {
            possibilitySelection(input);
            String[] suggestion = new String[Main.lengthArraySelection];

            if (suggestion.length > 1) {
                System.out.println(header);
                for (int i = 0; i < suggestion.length; i++) {
                    suggestion[i] = possibilitySelection(input)[i];
                    counter = i;
                    System.out.println(i + ":" + suggestion[i]);
                }

                System.out.println("\n" + select);

                input = Input.getInput();

            } else {
                suggestion[0] = possibilitySelection(input)[0];
                input = "0";
            }

            while (!running) {
                running=true;
                if (inputSelection.equals("0")) {
                    toBuy = selected(input, suggestion, inputSelection, toSell, toBuy);
                } else if (inputSelection.equals("1")) {
                    toSell = selected(input, suggestion, inputSelection, toSell, toBuy);
                }try {

                    int a = Integer.valueOf(input);
                    if (a > counter || a < 0) {
                        running = false;
                        System.out.println("Please enter a valid number.");
                    }
                }catch (NumberFormatException e){
                    System.out.println("Wrong Input");
                    running = false;
                }

                try {
                    if (!selectedAmount&&running) {
                        System.out.println(Header.headerOne(toSell, toBuy));

                    } else if (selectedAmount) {

                        sdrValue = Helper.sdrValue(toSell, toBuy);

                        convertedAmount = Helper.converter(sdrValue, enteredAmount);

                        System.out.println(Header.headerTwo(toSell, toBuy, enteredAmount, convertedAmount));
                        running=true;
                    }else if(!running){
                        input= Input.getInput();
                    }

                }catch (NullPointerException e) {
                    running = false;
                    System.out.println("ashdbasajsfasfasföa");
                    input = Input.getInput();

                }
                }
        }
            System.out.println(selectionStart + "\n\n" + exitStart);
            if (inputSelection.equals("0")) {
                return toBuy;
            } else {
                return toSell;
            }
        }


    /**
     * Methode possibilitySelection: Auslesen der Arrayliste, welche Währungen mit der Input des Benutzers
     * teilweise oder ganz übereinstimmen.
     *
     * @param input übergibt die Benutzereingabe
     * @return Array vorschlag, der die Selection der Länder enthält
     */
    public static String[] possibilitySelection(String input) {

        int counter = 0;
        String[] suggestion = new String[Main.currencylist.size()];
        for (int i = 0; i < suggestion.length; i++) {
            String cache = Main.currencylist.get(i).getName();
            String output = cache;
            if (cache.toLowerCase().contains(input.toLowerCase())) {
                suggestion[counter] = output;

                counter++;
            }

        }
        Main.lengthArraySelection = counter;
        return suggestion;
    }

    public static String selected(String input, String [] suggestion, String inputSelection, String toSell, String toBuy){

        for (int i = 0; i < suggestion.length; i++){

            if (input.equals("" + i)) {
                return suggestion[i];
            }
        }
        if (input.equals("xxx")){
            if(inputSelection.equals("0")){
                return toBuy;
            } else if (inputSelection.equals("1")){
                return toSell;
            }
        }

        return "not set";
    }
}
