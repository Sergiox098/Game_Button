package com.segomezcounal.game_button.game;

//Importación de Librerias

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.segomezcounal.game_button.databinding.FragmentGameBinding;
import com.segomezcounal.game_button.R;
import android.widget.Toast;
import android.os.Handler;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Clase Fragment

public class Game_Fragment extends Fragment {

    //Binding para acceder a los datos del layout
    private FragmentGameBinding binding;

    //Variables para el juego

    private boolean notPressed = true;
    private int colorTarget;
    private int colorCurrent;

    //Handler para manejar el ciclo

    private final Handler handler = new android.os.Handler();

    //Mapa que almacena los colores y sus nombres correspondientes.
    Map<Integer, String> colorMap = new HashMap<>();

    //Creación de la vista

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGameBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    //Inicialización de la vista

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Colores del juego

        colorMap.put(ContextCompat.getColor(requireContext(), R.color.negro), "Negro");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.blanco), "Blanco");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.rojo), "Rojo");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.verde), "Verde");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.azul), "Azul");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.amarillo), "Amarillo");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.cian), "Cian");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.magenta), "Magenta");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.gris), "Gris");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.naranja), "Naranja");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.rosado), "Rosado");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.morado), "Morado");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.marron), "Marrón");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.turquesa), "Turquesa");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.oliva), "Oliva");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.verde_lima), "Verde Lima");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.azul_claro), "Azul Cielo");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.dorado), "Dorado");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.plateado), "Plateado");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.vino), "Vino");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.coral), "Coral");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.salmon), "Salmón");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.lavanda), "Lavanda");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.menta), "Menta");
        colorMap.put(ContextCompat.getColor(requireContext(), R.color.perla), "Perla");

        // Llamada a la función para iniciar el ciclo
        changingButton();
        selectColor();

        // Sí el valor a buscar corresponde al color actual del botón,
        // se muestra un Toast indicando que el color es correcto y se detiene el ciclo.
        // En caso contrario, se muestra un Toast indicando que el color es incorrecto.

        binding.button.setOnClickListener(v -> {
            if (colorCurrent == colorTarget) {
                Toast.makeText(requireContext(), "Color Correcto", Toast.LENGTH_SHORT).show();
                notPressed = false;
            }
            else{
                Toast.makeText(requireContext(), "Color Incorrecto", Toast.LENGTH_SHORT).show();
                notPressed = true;
            }
        });
    }

    // Movimiento y cambio de color del botón
    private void changingButton() {
        // Se ejecuta cuando la vista ha sido creada.
        binding.getRoot().post(() -> {
            // Se crea un ciclo con Runnable
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    //  Sí el botoón no ha sido presionado:
                    if (notPressed) {
                        // Se crea una lista de colores.
                        List<Integer> colorKeys = new ArrayList<>(colorMap.keySet());
                        // Se selecciona un color aleatorio de la lista.
                        int randomIndex = new Random().nextInt(colorKeys.size());
                        colorCurrent = colorKeys.get(randomIndex);
                        // Se cambia el color del botón.
                        binding.button.setBackgroundColor(colorCurrent);

                        // Se obtienen los límites de la vista.
                        int textViewMargin = binding.textViewColor.getHeight();
                        int maxX = binding.getRoot().getWidth() - binding.button.getWidth();
                        int maxY = binding.getRoot().getHeight() - binding.button.getHeight();

                        // Se genera una nueva posición aleatoria para el botón.
                        int randomX = new Random().nextInt(Math.max(maxX, 1));
                        int randomY = new Random().nextInt(Math.max(maxY-60-textViewMargin, 1));

                        // Se anima el movimiento del botón con las coordenadas generadas.
                        binding.button.animate()
                                .x(randomX)
                                .y(randomY)
                                .setDuration(500)
                                .start();
                        // Se vuelve a ejecutar el ciclo.
                        handler.postDelayed(this, 750);
                    }
                }
            };
            // El handler ejecuta el ciclo.
            handler.post(runnable);
        });
    }
    // Se destruye la vista
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    // Se selecciona un color aleatorio de la lista de colores.
    public void selectColor(){
        Random random = new Random();
        // Se crea una lista de claves del mapa de colores.
        List<Integer> colorKeys = new ArrayList<>(colorMap.keySet());
        int randomColor = random.nextInt(colorKeys.size());
        int colorToFind = colorKeys.get(randomColor);
        // Se obtiene el nombre del color seleccionado.
        String textColor = "Busca el Color "+colorMap.get(colorToFind);
        // Se define el color a buscar
        colorTarget = colorToFind;
        // Se muestra el nombre del color en el TextView.
        binding.textViewColor.setText(textColor);
    }
}