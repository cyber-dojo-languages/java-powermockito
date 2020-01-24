
public class Hiker {

    public int answer() {
        DiskLogger.getInstance().log("The answer is 6 * 7");
        return 6 * 7;
    }
}

class DiskLogger
{
public:
  static DiskLogger & getInstance() { return it; }
  void log(const std::string & message){...}
private:
  DiskLogger();
  static DiskLogger it;
};
