import java.text.NumberFormat;

//This is our outer class for our nested inner classes.
//Inner classes create objects that are a part of our Computer class
public class Computer {

    private CPU mCPU;
    private RAM mRAM;
    private Storage mStorage;
    private VideoCard mVideoCard;
    //Can make outer class fields private and still have the nested classes access it.
    private NumberFormat currency = NumberFormat.getCurrencyInstance();

    //for the 'this' keyword, it references the calling object
    //There are multiple 'this' in a nested class structure
    //'this' references based on what innermost block you're in.


    public CPU getCPU() {
        return mCPU;
    }

    public RAM getRAM() {
        return mRAM;
    }

    public Storage getStorage() {
        return mStorage;
    }

    public VideoCard getVideoCard() {
        return mVideoCard;
    }

    @Override
    public String toString() {
        return "\n~~~Computer Specifications~~~\n" +
                mCPU + "\n" +
                mRAM + "\n" +
                mStorage + "\n" +
                mVideoCard + "\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + "Total Cost as Configured: " + currency.format(calculateCost());
    }

    public double calculateCost() {
        return mCPU.mPrice + mRAM.mPrice + mStorage.mPrice + mVideoCard.mPrice;

    }

    class CPU {
        private String mManufacturer, mCore;
        private double mSpeed, mPrice;

        public CPU(String manufacturer, String core, double speed, double price) {
            mManufacturer = manufacturer;
            mCore = core;
            mSpeed = speed;
            mPrice = price;

            //Associate mCPU field (outer class computer) to "this" (current CPU object)
            //'this' refers to the data in the constructor that we inputted.
            mCPU = this;
        }

        @Override
        public String toString() {
            return "CPU [" + mManufacturer + " " + mCore + " " + " " + mSpeed + " GHz "
                    + currency.format(mPrice) + "]";
        }
    }

    class RAM {
        private String mManufacturer;
        private double mCapacity;
        private double mSpeed, mPrice;

        public RAM(String manufacturer, double capacity, double speed, double price) {
            mManufacturer = manufacturer;
            mCapacity = capacity;
            mSpeed = speed;
            mPrice = price;

            mRAM = this;
        }



        @Override
        public String toString() {
            return "RAM [" + mManufacturer + " " + mCapacity + " GB " + mSpeed + " MHz"
                    + currency.format(mPrice) + "]";
        }
    }

    class Storage {
        private String mManufacturer;
        private double mCapacity;
        private double mPrice;
        private String mType;

        public Storage(String manufacturer, double capacity, String type, double price) {
            mManufacturer = manufacturer;
            mCapacity = capacity;
            mType = type;
            mPrice = price;

            mStorage = this;
        }

        @Override
        public String toString() {
            return "Storage [" + mManufacturer + " " + mCapacity + " TB " + mType + " "
                    + currency.format(mPrice) + ']';
        }
    }

    class VideoCard {
        private String mManufacturer;
        private double mCapacity;
        private String mMaxRes;
        private double mPrice;

        public VideoCard(String manufacturer, double capacity, String maxRes, double price) {
            mManufacturer = manufacturer;
            mCapacity = capacity;
            mMaxRes = maxRes;
            mPrice = price;

            mVideoCard = this;
        }

        @Override
        public String toString() {
            return "VideoCard [" + mManufacturer + " " + mCapacity + " " + mMaxRes + " pixels "
                    + currency.format(mPrice) + ']';
        }
    }
}
