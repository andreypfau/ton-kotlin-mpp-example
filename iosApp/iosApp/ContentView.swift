import SwiftUI
import shared

struct ContentView: View {
	let ton = Ton()

	var body: some View {
 	    let liteClient = ton.doInitLiteClient()
 		Text(ton.getLastBlockId(liteClient: liteClient))
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
