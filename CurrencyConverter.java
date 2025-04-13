package com.parthib;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class CurrencyConverter extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	
	private JComboBox<String> cb;
	private JComboBox<String> cb1;
	
	private static final String API_KEY = "5ae5cfc0392b3e54aea2493f"; 
  private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

  // Array of countries with corresponding currencies
  String[] countryCurrency = {"Country", "United Arab Emirates", "Afghanistan", "Albania", "Armenia", "Netherlands Antilles", "Angola", "Argentina", "Australia", "Aruba", "Azerbaijan", "Bosnia and Herzegovina", "Barbados", "Bangladesh", "Bulgaria", "Bahrain", "Burundi", "Bermuda", "Brunei", "Bolivia", "Brazil", "Bahamas", "Bhutan", "Botswana", "Belarus", "Belize", "Canada", "Democratic Republic of the Congo", "Switzerland", "Chile", "China", "Colombia", "Costa Rica", "Cuba", "Cape Verde", "Czech Republic", "Djibouti", "Denmark", "Dominican Republic", "Algeria", "Egypt", "Eritrea", "Ethiopia", "European Union", "Fiji", "Falkland Islands", "Faroe Islands", "United Kingdom", "Georgia", "Guernsey", "Ghana", "Gibraltar", "The Gambia", "Guinea", "Guatemala", "Guyana", "Hong Kong", "Honduras", "Croatia", "Haiti", "Hungary", "Indonesia", "Israel", "Isle of Man", "India", "Iraq", "Iran", "Iceland", "Jersey", "Jamaica", "Jordan", "Japan", "Kenya", "Kyrgyzstan", "Cambodia", "Kiribati", "Comoros", "South Korea", "Kuwait", "Cayman Islands", "Kazakhstan", "Laos", "Lebanon", "Sri Lanka", "Liberia", "Lesotho", "Libya", "Morocco", "Moldova", "Madagascar", "North Macedonia", "Myanmar", "Mongolia", "Macau", "Mauritania", "Mauritius", "Maldives", "Malawi", "Mexico", "Malaysia", "Mozambique", "Namibia", "Nigeria", "Nicaragua", "Norway", "Nepal", "New Zealand", "Oman", "Panama", "Peru", "Papua New Guinea", "Philippines", "Pakistan", "Poland", "Paraguay", "Qatar", "Romania", "Serbia", "Russia", "Rwanda", "Saudi Arabia", "Solomon Islands", "Seychelles", "Sudan", "Sweden", "Singapore", "Saint Helena", "Sierra Leone", "Somalia", "Suriname", "South Sudan", "São Tomé and Príncipe", "Syria", "Eswatini", "Thailand", "Tajikistan", "Turkmenistan", "Tunisia", "Tonga", "Turkey", "Trinidad and Tobago", "Tuvalu", "Taiwan", "Tanzania", "Ukraine", "Uganda", "United States", "Uruguay", "Uzbekistan", "Venezuela", "Vietnam", "Vanuatu", "Samoa", "CEMAC", "Organisation of Eastern Caribbean States", "International Monetary Fund", "CFA", "Collectivités d'Outre-Mer", "Yemen", "South Africa", "Zambia", "Zimbabwe"};

	// Constructor for setting up the GUI components
	public CurrencyConverter() {
		setTitle("Currency Converter");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Setting up the title label
		JLabel lb1 = new JLabel("Currency Converter");
		lb1.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lb1.setHorizontalAlignment(SwingConstants.CENTER);
		lb1.setBounds(264, 11, 307, 83);
		contentPane.add(lb1);

		// Labels for "From" and "To" fields
		JLabel lb2 = new JLabel("From");
		lb2.setHorizontalAlignment(SwingConstants.LEFT);
		lb2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lb2.setBounds(56, 148, 294, 45);
		contentPane.add(lb2);
		
		JLabel lbl3 = new JLabel("To");
		lbl3.setHorizontalAlignment(SwingConstants.LEFT);
		lbl3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbl3.setBounds(462, 148, 294, 45);
		contentPane.add(lbl3);

		// ComboBox for selecting the currency to convert from
		JComboBox cb = new JComboBox();
		cb.setModel(new DefaultComboBoxModel(new String[] {"Choose one...", "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTN", "BWP", "BYN", "BZD", "CAD", "CDF", "CHF", "CLP", "CNY", "COP", "CRC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "FOK", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KID", "KMF", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LYD", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRU", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLE", "SOS", "SRD", "SSP", "STN", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", "TVD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VES", "VND", "VUV", "WST", "XAF", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMW", "ZWL"}));
		cb.setMaximumRowCount(120);
		cb.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cb.setBounds(56, 232, 294, 45);
		contentPane.add(cb);

    // ComboBox for selecting the currency to convert To
		JComboBox cb1 = new JComboBox();
		cb1.setModel(new DefaultComboBoxModel(new String[] {"Choose one...", "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTN", "BWP", "BYN", "BZD", "CAD", "CDF", "CHF", "CLP", "CNY", "COP", "CRC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "FOK", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KID", "KMF", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LYD", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRU", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLE", "SOS", "SRD", "SSP", "STN", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", "TVD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VES", "VND", "VUV", "WST", "XAF", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMW", "ZWL"}));
		cb1.setMaximumRowCount(120);
		cb1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cb1.setBounds(462, 232, 294, 45);
		contentPane.add(cb1);

		// Labels to display the selected country
		JLabel unit1 = new JLabel("Country");
		unit1.setHorizontalAlignment(SwingConstants.RIGHT);
		unit1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		unit1.setBounds(56, 395, 294, 36);
		contentPane.add(unit1);
		
		JLabel unit2 = new JLabel("Country");
		unit2.setHorizontalAlignment(SwingConstants.RIGHT);
		unit2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		unit2.setBounds(462, 395, 294, 36);
		contentPane.add(unit2);

		// TextFields for entering the amount and displaying the converted amount
		t1 = new JTextField();
		t1.setHorizontalAlignment(SwingConstants.LEFT);
		t1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		t1.setBounds(56, 312, 294, 45);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setHorizontalAlignment(SwingConstants.LEFT);
		t2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		t2.setColumns(10);
		t2.setBounds(462, 312, 294, 45);
		contentPane.add(t2);

		// Convert button and its action listener
		JButton bConvert = new JButton("Convert");
		
		bConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Ensure valid input before proceeding with the conversion 
				if(cb.getSelectedIndex() == 0 || cb1.getSelectedIndex() == 0 || t1.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"You must select both the country currency code and enter the amount","Error Message", JOptionPane.INFORMATION_MESSAGE);
					
					return;
				}
        // Fetch the conversion rate and perform the currency conversion
				String baseCurrency = (String) cb.getSelectedItem();
		    String targetCurrency = (String) cb1.getSelectedItem();
		    double amount = Double.parseDouble(t1.getText());
		    double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
		    double convertedAmount = amount * exchangeRate;
		    t2.setText(String.format("%.2f", convertedAmount));
				

			}
			
		});
		bConvert.setFont(new Font("Times New Roman", Font.BOLD, 20));
		bConvert.setBounds(140, 472, 210, 45);
		contentPane.add(bConvert);

		// Reset button to clear selections and text fields
		JButton bReset = new JButton("Reset");
		bReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cb.setSelectedIndex(0);
				cb1.setSelectedIndex(0);
				
				t1.setText(null);
				t2.setText(null);
			}
		});
		bReset.setFont(new Font("Times New Roman", Font.BOLD, 20));
		bReset.setForeground(new Color(0, 0, 0));
		bReset.setBounds(464, 472, 210, 45);
		contentPane.add(bReset);

		// Update the country labels when a currency is selected
		cb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int index = cb.getSelectedIndex();
				unit1.setText(countryCurrency[index]);
			}
		});
		
		cb1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int index = cb1.getSelectedIndex();
				unit2.setText(countryCurrency[index]);
			}
		});
	}
	
	// Method to fetch the exchange rate from the API
	private double getExchangeRate(String unit1, String unit2) {
        try {
            URL url = new URL(API_URL + unit1);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = inputReader.readLine()) != null) {
                response.append(line);
            }

            inputReader.close();

            String jsonResponse = response.toString();
            int startIndex = jsonResponse.indexOf("\"" + unit2 + "\":");
            int endIndex = jsonResponse.indexOf(",", startIndex);
            String rateSubstring = jsonResponse.substring(startIndex, endIndex);

            return Double.parseDouble(rateSubstring.split(":")[1]);
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    // Main method to launch the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CurrencyConverter frame = new CurrencyConverter();
            frame.setVisible(true);
        });
    }
}
