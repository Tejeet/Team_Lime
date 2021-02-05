package com.tejeet.tataclicq_clone.Listners;

import com.tejeet.tataclicq_clone.DataNModels.MyCartModel;

public interface MyCartProductClickListner {

    public void onProductRemove(MyCartModel data, int position);
}
