package com.example.actives.ui.view;

import com.example.actives.base.IBaseView;
import com.example.actives.data.model.MostActiveStock;

import java.util.List;

/**
 * Created by Angelina Fedorova
 */

public interface IActiveStockView extends IBaseView {

    /**
     * Вызывается при нажатии на кнопку "SHOW"
     * @param mostActiveStockList  список акций торгующихся компаний
     */
    void loadActiveStock(List<MostActiveStock> mostActiveStockList);

}
