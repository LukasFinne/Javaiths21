package se.iths.java21.streams;

public record Car(long id, String model, String brand, int year, int price){ //Om man vill uppdatera något så får man fixa det med hjälp av kopiering så, ta bort pris gör ett nytt pris sen kopiera over resten
}
