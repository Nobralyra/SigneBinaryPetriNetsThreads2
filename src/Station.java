public class Station
{
    private Switch switchOne;
    private Switch switchTwo;

    private Track trackOne;
    private Track trackTwo;
    private Track trackRight;
    private Track trackLeft;

    /**
     * Public method that checks if the train can arrive at the station.
     * If trackOne and TrackTwo has a Train, then it returns false
     * If one of them is empthy the Train can arrive
     * @param arriveAt
     * @return
     */
    public boolean CanArrive (int arriveAt)
    {
        if (trackOne.Value == 1 && trackTwo.Value == 1)
        {
            return false; //no track available
        }
       return true;
    }

    /**
     * Public method that changes the tracks value when the Train arrives to the station
     * If the Train arrives to trackOne or TrackTwo it sets the value to 1, and
     * sets the track where it arrives from to 0
     * @param arriveAt
     * @param arriveFrom
     */
    public void Arrive(int arriveAt, int arriveFrom)
    {
        switch (arriveAt)
        {
            case 1: trackOne.setValue(1);
                break;
            case 2: trackTwo.setValue(1);
                break;
        }
        switch (arriveFrom)
        {
            case 1:
                trackLeft.setValue(0);
                break;
            case 2:
                trackRight.setValue(0);
        }
    }

    /**
     * Public method that checks if the Train can depart to trackLeft or trackRight
     * when it wishes to depart the station
     * @param departTo
     * @return
     */
    public boolean CanDepart (int departTo)
    {
        switch (departTo)
        {
            case 1:
                if (trackLeft.Value == 0)
                {
                    return true;
                }
                break;
            case 2:
                if (trackRight.Value == 0)
                {
                    return true;
                }
                break;
        }
        return false;
    }

    /**
     * Public method that changes the tracks value when the Train departs from the station
     * If the Train arrives to trackLeft or TrackRight it sets the value to 1, and
     * sets the track where it arrives from to 0
     * @param departFrom
     * @param departTo
     */
    public void Depart (int departFrom, int departTo)
    {
        switch (departTo)
        {
            case 1:
                trackLeft.setValue(1);
                break;
            case 2:
                trackRight.setValue(1);
        }
        switch (departFrom)
        {
            case 1:
                trackOne.setValue(0);
                break;
            case 2:
                trackTwo.setValue(0);
        }
    }

    /**
     * Public method that changes the tracks value when the Train is arriving at trackLeft
     * or trackRight from outside of the tracks
     * @param trackToStation
     */
    public void GoToStation (int trackToStation)
    {
        switch (trackToStation)
        {
            case 1:
                trackLeft.setValue(1);
                break;
            case 2:
                trackRight.setValue(1);
        }
    }

    /**
     * Public method that checks if it possible for the train to actually go to
     * the station
     * @return
     */
    public boolean isTrackAvailable ()
    {
        return (CanArrive(1) //trackOne
                || CanArrive(2) //trackTwo
                || (CanDepart(1) && CanDepart(2)));
                //trackLeft and trackRight
    }
}
