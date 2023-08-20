import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(val name : String, val category: String, val type: String) {
    var deviceStatus = "online"
        protected set

    open val deviceType = "unknown"
    open fun turnOn() {
        deviceStatus = "on"
    }
    open fun turnOff() {
        deviceStatus = "off"
    }

    open fun printDeviceInfo() {
        println("The Device Name is $name ,the device category is $category and type is $type")
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
        SmartDevice(name = deviceName, category = deviceCategory, type = "Smart TV") {
    override val deviceType = type

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

   override fun turnOff() {
       super.turnOff()
       println("$name turned off")
   }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker Volume Increased to $speakerVolume")
    }

    fun nextChannel() {
        channelNumber++
        println("Speaker Volume Increased to $channelNumber")
    }

    override fun printDeviceInfo() {
        super.printDeviceInfo()
    }

        }

class SmartLightDevice(deviceName: String, deviceCategory: String) :
        SmartDevice(name = deviceName, category = deviceCategory, type = "Smart Light") {
    override val deviceType = type
    private var brightnessLevel by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name is turned on. The brightness level is $brightnessLevel")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("$name is turned off")
    }

    override fun printDeviceInfo() {
        super.printDeviceInfo()
    }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel")
    }

        }
class SmartHome(val smartTvDevice: SmartTvDevice, val smartLightDevice: SmartLightDevice) {
    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }
    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }
    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }
    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }
    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }
    fun turnOffAllDevice() {
       turnOffTv()
       turnOffLight()
    }

    fun printDeviceInfoForTV() {
        smartTvDevice.printDeviceInfo();
    }

    fun printDeviceInfoForLight() {
        smartLightDevice.printDeviceInfo();
    }
}
class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {
    private var fieldData = initialValue
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData;
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if(value in minValue..maxValue) {
            fieldData = value
        }
    }

}
fun main(args: Array<String>) {
    val smartHome = SmartHome(
        SmartTvDevice(deviceName = "Android TV", deviceCategory = "Entertainment"),
        SmartLightDevice(deviceName = "Google light", deviceCategory = "Utility")
    )

    smartHome.turnOnTv()
    smartHome.turnOnLight()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
    println()

    smartHome.increaseTvVolume()
    smartHome.changeTvChannelToNext()
    smartHome.increaseLightBrightness()
    println()

    smartHome.turnOffAllDevice()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")

    smartHome.printDeviceInfoForTV()
    smartHome.printDeviceInfoForLight()
}