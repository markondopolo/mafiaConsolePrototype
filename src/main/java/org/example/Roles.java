package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Roles {

    /**
     * Данный клас хранит в себе названия ролей и
     * назначает случайным образом всех игроков на какую-то роль и хранит эту информацию
     * айдишники в проэкте лежат в хеш сете, поэтому иммитируем работу с хеш сетом
     * запишем все данные в хеш мапу
     */


    // protected final String[] roles = {"Civilian", "Mafia", "Commissar", "Doctor", "Prostitute"};

    public HashMap<String, String> playerRoles = new HashMap<>();

    protected void setPlayerRoles(Set<String> playerIDs, boolean clean) {
        // метод заполняет пустую мапу получая на вход айдишники и роли
        // при вызове второй раз нужно добавить очищение всех параметров в мапе в массиве аrr

        if (clean == true) {
            playerRoles.clear();
        }

        ArrayList<String> list = new ArrayList<>(playerIDs);

        String[] arr = assignRoles(playerIDs.size());

        for (int i = 0; i < list.size(); i++) {
            // System.out.println("list =" + list.get(i) + " arr = " + arr[i]);// для отображения то что мы засунем в каждую ячейку мапы
            playerRoles.put(list.get(i), arr[i]);
        }
    }

    private String[] assignRoles(int number) {

        String[] setOfRoles = new String[number];
        ArrayList<String> special = new ArrayList<>();


        if (number < 4) {
        }// если  игроков <4 то выбросить мессагу про то что игра не имеет смысла}

        if (number == 4) { // если 4 игрока то 2 мирных, 1 коммисар и 1 мафия

            special.add("Civilian");
            special.add("Civilian");
            special.add("Mafia");
            special.add("Commissar");

            randomAssignment(setOfRoles, special);
        }


        if (number == 5) { // если 5 игроков то 2 мирных 1 коммисар, 1 доктор и 1 мафия
            special.add("Civilian");
            special.add("Civilian");
            special.add("Mafia");
            special.add("Commissar");
            special.add("Doctor");

            randomAssignment(setOfRoles, special);
        }

        if (number == 6) { // если 6 игроков то 3 мирных 1 коммисар, 1 доктор и 1 мафия
            special.add("Civilian");
            special.add("Civilian");
            special.add("Civilian");
            special.add("Mafia");
            special.add("Commissar");
            special.add("Doctor");

            randomAssignment(setOfRoles, special);
        }

        if (number == 7) { // если 7 игроков то 3 мирных, 1 коммисар, 1 доктор, и 2 мафии
            special.add("Civilian");
            special.add("Civilian");
            special.add("Civilian");
            special.add("Mafia");
            special.add("Mafia");
            special.add("Commissar");
            special.add("Doctor");

            randomAssignment(setOfRoles, special);
        }

        if (number == 8) { // если 8 игроков то 3 мирных, 1 коммисар, 1 доктор, 1 шлюха и 2 мафии
            special.add("Civilian");
            special.add("Civilian");
            special.add("Civilian");
            special.add("Mafia");
            special.add("Mafia");
            special.add("Commissar");
            special.add("Doctor");
            special.add("Prostitute");

            randomAssignment(setOfRoles, special);
        }

        return setOfRoles;
    }

    private void randomAssignment(String[] setOfRoles, ArrayList<String> special) {
        while (special.size() != 0) {

            int randomNumberOfCell = 0;
            double numDouble = 0;

            for (int i = 0; i < setOfRoles.length; i++) {
                numDouble = Math.random() * special.size();
                randomNumberOfCell = (int) numDouble;
                // System.out.println("randomNumberOfCell "+ randomNumberOfCell+" numDouble  "+numDouble);
                setOfRoles[i] = special.get(randomNumberOfCell);
                special.remove(randomNumberOfCell);
            }
        }
    }

}


