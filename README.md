# Currency Converter – Terminal-Anwendung

Diese Java-Konsolenanwendung ermöglicht den Umtausch zwischen vordefinierten Währungen über SDR (Special Drawing Rights) als Zwischenschritt.

---

## 📌 Inhaltsverzeichnis

- [Einführung](#einführung)  
- [Funktionsweise](#funktionsweise)  
- [Installation & Start](#installation--start)  
- [Verwendung](#verwendung)  
- [Umsetzungsdetails](#umsetzungsdetails)  
- [Autor:innen](#autorinnen)  
- [Lizenz](#lizenz)

---

## 🧭 Einführung

Der Currency Converter ist ein Bonusprojekt aus dem Sommersemester 2017 im Modul Software Development 1 an der HDM Stuttgart. Ziel ist es, einen Währungsrechner zu implementieren, der den Umrechnungskurs über IMF‑SDR nutzt.

---

## ⚙️ Funktionsweise

1. Die Anwendung liest eine tabellarische Textdatei (`currencies.txt`), die Währungskürzel und ihre SDR-Äquivalente enthält.
2. Der/die Nutzer:in wählt eine „Kauf‑“ (buy) und eine „Verkauf‑“ (sell) Währung sowie einen Betrag.
3. Die Umrechnung erfolgt in zwei Schritten:
   - Betrag → SDR
   - SDR → Zielwährung

Dadurch genügt die Speicherung eines einzigen Umrechnungskurses pro Währung.

---

## 🚀 Installation & Start

```bash
# Projekt klonen
git clone <REPO-URL>
cd <PROJECT-FOLDER>

# Kompilieren
javac CurrencyConverter.java

# Starten (Beispiel)
java CurrencyConverter currencies.txt
```

> `currencies.txt` ist eine Datei mit Währungsnamen und deren SDR-Kursen (z. B. „Euro: 1.264280“)

---

## 🎯 Verwendung

1. Nach dem Start gibst du die Datei mit den Währungskursen an.
2. Wähle die Ausgangswährung (z. B. Euro), die Zielwährung (z. B. US-Dollar) und den Betrag.
3. Die App zeigt dir den umgerechneten Wert an.
4. Du kannst erneut rechnen oder das Programm beenden.

---

## 🔍 Umsetzungsdetails

- **Datenstruktur:** Ein Array oder eine Map speichert Währungsname + Kurswert.  
- **Datei-Input:** Java `Scanner` oder `BufferedReader` liest `currencies.txt`.  
- **Kodierungsprinzip:** Umrechnung über SDR ermöglicht flexible Conversion zwischen beliebigen Währungspaaren.  
- **Benutzeroberfläche:** Konsolenbasiert mit klaren Anweisungen und Fehlerprüfung bei ungültigen Eingaben.

---

## 👥 Autor:innen

Mascha Weis
Susanne Weiß
Alexander Kraus

