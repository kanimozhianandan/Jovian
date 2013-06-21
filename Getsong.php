<?php
$ch = curl_init();
$search = $_POST["q"]; # q is the search term you provide in the form.
$tinyurl = "http://tinysong.com/s/".$search."?format=json&key=a435158024ee1a23fbfe56a45e351941";
curl_setopt($ch,CURLOPT_URL,$tinyurl);
curl_setopt($ch,CURLOPT_RETURNTRANSFER,TRUE);
curl_setopt($ch,CURLOPT_BINARYTRANSFER,TRUE);
$start=curl_exec($ch);
$data = json_decode($start);
$len = count($data);
echo "List of songs for the search term are:\n";
for ($i=0; $i<$len; $i++) 
{
echo ($i+1 . ".");
echo ($data[$i]->SongName . " from ");
echo ($data[$i]->AlbumName . "\n");
}
echo "Choose the song you wish to hear by replying back the no.:  \n  ";
curl_close($ch);
?>
