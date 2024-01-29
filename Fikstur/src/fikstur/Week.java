/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fikstur;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author mtpc
 */

class Week implements Serializable{
    private final List<Pair> pairs;

    public Week(List<Pair> pairs) {
        this.pairs = pairs;
    }
    
    public List<Pair> getPairs() {
        return pairs;
    }
}
