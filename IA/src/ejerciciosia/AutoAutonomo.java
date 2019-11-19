/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosia;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.MultiLayerPerceptron;

/**
 *
 * @author JASMIN-SOMA
 */
public class AutoAutonomo {
    public static void main(String[] args) {
        // TODO code application logic here
        NeuralNetwork neuralNetwork = new MultiLayerPerceptron(2,10,2);
        // create training set 
        DataSet trainingSet = new  DataSet(2, 2); 
        // add training data to training set (logical OR function) 
        trainingSet.add (new DataSetRow (new double[]{-1, 0}, new double[]{1, 0})); 
        trainingSet.add (new DataSetRow (new double[]{-1, 1}, new double[]{1, 0}));
        trainingSet.add (new DataSetRow (new double[]{-1, -1}, new double[]{1, -1}));
        trainingSet.add (new DataSetRow (new double[]{0, 1}, new double[]{1, 1}));
        trainingSet.add (new DataSetRow (new double[]{0, -1}, new double[]{1, 1}));
        trainingSet.add (new DataSetRow (new double[]{0, 0}, new double[]{1, 0}));
        trainingSet.add (new DataSetRow (new double[]{1, 1}, new double[]{-1, 1}));
        trainingSet.add (new DataSetRow (new double[]{1, -1}, new double[]{-1, -1}));
        trainingSet.add (new DataSetRow (new double[]{1,0}, new double[]{-1, 1}));
        // learn the training set 
        //neuralNetwork.learn(trainingSet);
        
        // save the trained network into file 
        neuralNetwork.save("autoAutonomo_multilayer.nnet");
        
        // load the saved network 
        neuralNetwork = NeuralNetwork.createFromFile("autoAutonomo_multilayer.nnet");
        
        // set network input 
        neuralNetwork.setInput(-1, 0);
        
        // calculate network 
        neuralNetwork.calculate();
        
        // get network output 
        double[] networkOutput = neuralNetwork.getOutput();
        
        //display
        for(int i=0;i<networkOutput.length;i++){
            System.out.println("Salida= " + networkOutput[i]);
        }
    }
}
