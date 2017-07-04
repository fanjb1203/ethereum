package com.blackbrother.util;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URL;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.parity.Parity;

public class Test {
	private static Parity parity = ParityClient.getParity();
	private static Web3j web3j = Web3JClient.getClient();

	public static void sendTransaction() {
		String data = HexUtils.encode("上海1a");
		System.out.println(data);
		Transaction transaction = new Transaction(
				"0x882f967839a9984ca20569d703900aa180b9b548", null, new BigInteger("20000000000"), new BigInteger("21545"),
				"0xeb97bed0631515013f58b066b8e8561694e06a3b", new BigInteger("100000"),data);
		try {
			EthSendTransaction ethSendTransaction = parity.personalSignAndSendTransaction(transaction, "111111").send();
			System.out.println(ethSendTransaction.getTransactionHash());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String hexString2String(String src) {  
        String temp = "";  
        for (int i = 0; i < src.length() / 2; i++) {  
            temp = temp  
                    + (char) Integer.valueOf(src.substring(i * 2, i * 2 + 2),  
                            16).byteValue();  
        }  
        return temp;  
    }  

	public static String toHexString(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return "0x"+str;
	}

	public static void main(String[] args) throws IOException {
//		EthTransaction ethTransaction = web3j.ethGetTransactionByHash("0x5782f44eea77bb9d0fd2afe363ed47bc4daf1058f9ca461ab195ced5d015b1e2").send();
//		System.out.println(HexUtils.decode(ethTransaction.getResult().getInput()));
//		System.out.println(ethTransaction.getResult().getInput());
////		System.out.println(ethTransaction.getTransaction());
////		sendTransaction();
////		String data = HexUtils.encode("8656771459056330000");
////		Transaction transaction = new Transaction(
////				"0x882f967839a9984ca20569d703900aa180b9b548", null, null, null,
////				"0xeb97bed0631515013f58b066b8e8561694e06a3b", new BigInteger("50000000000000"),data);
////				EthEstimateGas ethEstimateGas = web3j.ethEstimateGas(transaction).send();
////				System.out.println(ethEstimateGas.getAmountUsed());
////				System.out.println(web3j.ethGasPrice().send().getGasPrice());
////		EthBlock ethBlock = web3j.ethGetBlockByNumber(new DefaultBlockParameterNumber(new BigInteger("15037")), true).send();
////		System.out.println(ethBlock.getResult().getNonce());
////		EthCoinbase ethCoinbase = parity.ethCoinbase().send();
////		System.out.println(ethCoinbase.getResult());
//		EthGetBlockTransactionCountByNumber ethGetBlockTransactionCountByNumber = web3j.ethGetBlockTransactionCountByNumber(new DefaultBlockParameterNumber(new BigInteger("15139"))).send();
//		System.out.println(ethGetBlockTransactionCountByNumber.getTransactionCount());
//		EthGetBalance ethGetBalance = web3j.ethGetBalance("0x882f967839a9984ca20569d703900aa180b9b548", DefaultBlockParameterName.LATEST).send();
////		EthTransaction ethTransaction = web3j.ethGetTransactionByHash("0x5782f44eea77bb9d0fd2afe363ed47bc4daf1058f9ca461ab195ced5d015b1e2").send();
//		System.out.println("0xdfe33cc67a0ff22d01e647b8c751ea851fc2d612f41f94dc1af342c0acb45180".length());
//		System.out.println(hexString2String("606060405234610000575b60008054600160a060020a03191633600160a060020a0390811691909117808355168152600160208190526040909120555b5b6107148061004c6000396000f300606060405236156100885763ffffffff60e060020a6000350416630121b93f811461008d578063013cf08b146100af5780632e4176cf146100d8578063429b92bf146101015780635c19a95c14610123578063609ff1bd14610150578063745fd7511461017b5780639e7b8d61146101e2578063a3ec138d1461020f578063e503bab614610256575b610000565b346100005761009d6004356102bb565b60408051918252519081900360200190f35b34610000576100bf600435610335565b6040805192835260208301919091528051918290030190f35b34610000576100e5610361565b60408051600160a060020a039092168252519081900360200190f35b346100005761009d600435610370565b60408051918252519081900360200190f35b346100005761013c600160a060020a0360043516610399565b604080519115158252519081900360200190f35b346100005761015d61050e565b60408051938452602084019290925282820152519081900360600190f35b346100005761013c600480803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437509496506105a095505050505050565b604080519115158252519081900360200190f35b346100005761013c600160a060020a036004351661063f565b604080519115158252519081900360200190f35b3461000057610228600160a060020a03600435166106a9565b604080519485529215156020850152600160a060020a03909116838301526060830152519081900360800190f35b346100005761009d600480803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437509496506106dd95505050505050565b60408051918252519081900360200190f35b600160a060020a033316600090815260016020819052604082209081015460ff16156102e657610000565b6001818101805460ff19169091179055600280820184905581548154909190859081101561000057906000526020600020906002020160005b5060010180549091019055805491505b50919050565b600281815481101561000057906000526020600020906002020160005b50805460019091015490915082565b600054600160a060020a031681565b6000600282815481101561000057906000526020600020906002020160005b505490505b919050565b600160a060020a0333166000908152600160208190526040822090810154829060ff16156103c657610000565b5b600160a060020a0384811660009081526001602081905260409091200154610100900416158015906104215750600160a060020a038481166000908152600160208190526040909120015461010090048116339190911614155b1561045257600160a060020a03938416600090815260016020819052604090912001546101009004909316926103c7565b33600160a060020a031684600160a060020a0316141561047157610000565b506001818101805460ff1916821774ffffffffffffffffffffffffffffffffffffffff001916610100600160a060020a0387169081029190911790915560009081526020829052604090209081015460ff16156104fa578154600282810154815481101561000057906000526020600020906002020160005b5060010180549091019055610502565b815481540181555b600192505b5050919050565b60008080805b6002548110156105995782600282815481101561000057906000526020600020906002020160005b5060010154111561059057600281815481101561000057906000526020600020906002020160005b50600101549250809350600281815481101561000057906000526020600020906002020160005b505491505b5b600101610514565b5b50909192565b600060006105ad836106dd565b9050600280548060010182818154818355818115116105ff576002028160020283600052602060002091820191016105ff91905b808211156105fb57600080825560018201556002016105e1565b5090565b5b505050916000526020600020906002020160005b5060408051808201909152838152600060209091018190528382556001918201559250505b50919050565b6000805433600160a060020a03908116911614158061067a5750600160a060020a0382166000908152600160208190526040909120015460ff165b1561068457610000565b50600160a060020a03811660009081526001602081905260409091208190555b919050565b600160208190526000918252604090912080549181015460029091015460ff8216916101009004600160a060020a03169084565b60208101515b9190505600a165627a7a7230582090e2389a9fa9e9da0f20a815bf9fbf13b5f27996d83233abde68fa1052dc6f760029"));
//		System.out.println(hexString2String("3133383131313536373838")); 
//		System.out.println(toHexString("abc"));
//		Web3Sha3 web3Sha3 = web3j.web3Sha3(HexUtils.encode("汉字")).send();
//		System.out.println(web3Sha3.getResult());
//		EthSign ethSign = web3j.ethSign("0x882f967839a9984ca20569d703900aa180b9b548", web3Sha3.getResult()).send();
//		System.out.println(ethSign.getSignature());
//		PersonalEcRecover personalEcRecover = parity.personalEcRecover(web3Sha3.getResult(), ethSign.getSignature()).send();
//		System.out.println(personalEcRecover.getResult());
//		
		
//		Credentials credentials = null;
//	    String password = "111111";
//	    String pathToWalletFile = "//192.168.9.44/home/fanjianbin/eth/chain/keystore/UTC--2017-03-24T01-53-19.639609974Z--882f967839a9984ca20569d703900aa180b9b548";
//	    File file = new File(pathToWalletFile);
//
//	    try {
//	        credentials = WalletUtils.loadCredentials(
//	                password,
//	                file
//	        );
//	    } catch (CipherException e) {
//	        e.printStackTrace();
//	    }
//	    System.out.println(credentials);
		
	        URL url = new URL("http://192.168.9.44/home/fanjianbin/eth/chain/keystore/UTC--2017-03-24T01-53-19.639609974Z--882f967839a9984ca20569d703900aa180b9b548");  
	        InputStream ism=url.openStream();  
	        byte[] bytes=new byte[1024];  
	        ism.read(bytes);  
	        String str=new String(bytes,"utf-8");  
	        System.err.println(str);  
	        while(ism.read(bytes)>-1){  
	            System.err.println(str);  
	        }  
	    }  

}
